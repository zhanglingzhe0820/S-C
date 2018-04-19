package cn.s_c.bl.order;

import cn.s_c.blservice.admin.AdminBlService;
import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.dataservice.suppiler.SupplierDataService;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.order.FoodOrder;
import cn.s_c.entity.order.Order;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.exception.UserDoesNotFaithException;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderFood;
import cn.s_c.vo.order.OrderList;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBlServiceImpl implements OrderBlService {
    @Autowired
    private OrderDataService orderDataService;
    @Autowired
    private FoodDataService foodDataService;
    @Autowired
    private SupplierDataService supplierDataService;
    @Autowired
    private RestaurantDataService restaurantDataService;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private AdminBlService adminBlService;

    /**
     * get the orders by username
     *
     * @param supplierUsername the username of the supplier
     * @param startHour        the start Hour
     * @param startMinute      the start minute
     * @param endHour          the end hour
     * @param endMinute        the end minute
     * @return the list of orders
     */
    @Override
    public OrderList[] getOrders(String supplierUsername, int startHour, int startMinute, int endHour, int endMinute) {
        Supplier supplier = supplierDataService.getSupplierByUsername(supplierUsername);
        String position = supplier.getName();
        String restaurantName = restaurantDataService.getRestaurantById(supplier.getRestaurantId()).getName();
        List<Order> orderList = orderDataService.getAllOrders();
        List<OrderList> orderListList = makeOrderListTimeFramework(startHour, startMinute, endHour, endMinute);
        for (Order order : orderList) {
            if (!order.isConfirmed()) {
                for (FoodOrder foodOrder : order.getFoodList()) {
                    if (foodOrder.getPosition().equals(position) && foodOrder.getRestaurantName().equals(restaurantName)) {
                        for (int i = 0; i < orderListList.size(); i++) {
                            OrderList orderList1 = orderListList.get(i);
                            if ((getMinutes(orderList1.getStartTime()) <= order.getPickHour() * 60 + order.getPickMinute()) && (getMinutes(orderList1.getEndTime()) > order.getPickHour() * 60 + order.getPickMinute())) {
                                List<OrderFood> orderFoodList = orderList1.getOrderFoodList();
                                boolean isAdded = false;
                                for (int j = 0; j < orderFoodList.size(); j++) {
                                    if (foodOrder.getName().equals(orderFoodList.get(j).getName())) {
                                        orderFoodList.get(j).setNum(orderFoodList.get(j).getNum() + foodOrder.getNum());
                                        isAdded = true;
                                        break;
                                    }
                                }
                                if (!isAdded) {
                                    OrderFood orderFood = new OrderFood(foodOrder.getName(), foodOrder.getPrice(), foodOrder.getNum());
                                    orderList1.getOrderFoodList().add(orderFood);
                                }
                            }
                        }
                    }
                }
            }
        }
        return orderListList.toArray(new OrderList[orderListList.size()]);
    }

    private List<OrderList> makeOrderListTimeFramework(int startHour, int startMinute, int endHour, int endMinute) {
        int interval = 10;
        List<OrderList> orderListList = new ArrayList<>();
        int nowHour = startHour;
        int nowMinute = startMinute;
        while (nowHour * 60 + nowMinute < endHour * 60 + endMinute) {
            OrderList orderList;
            if ((nowHour * 60 + endMinute + interval) >= endHour * 60 + endMinute) {
                orderList = new OrderList(nowHour + ":" + (nowMinute != 0 ? nowMinute : "00"), endHour + ":" + (endMinute != 0 ? endMinute : "00"), new ArrayList<>());
                nowHour = endHour;
                nowMinute = endMinute;
            } else {
                String endTime = minutesToHour(nowHour * 60 + nowMinute + interval);
                orderList = new OrderList(nowHour + ":" + nowMinute, endTime, new ArrayList<>());
                nowHour = Integer.parseInt(endTime.split(":")[0]);
                nowMinute = Integer.parseInt(endTime.split(":")[1]);
            }
            orderListList.add(orderList);
        }
        return orderListList;
    }

    private String minutesToHour(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return hour + ":" + (minute != 0 ? minute : "00");
    }

    private int getMinutes(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    /**
     * save the order
     *
     * @param orderSaveVo the order to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveOrder(OrderSaveVo orderSaveVo) throws UserDoesNotFaithException {
        adminBlService.confirmFaith();
        for (FoodOrder foodOrder : orderSaveVo.getFoodList()) {
            Food food = foodDataService.getFoodById(foodOrder.getId());
            if (food.getEndHour() * 60 + food.getEndMinute() < orderSaveVo.getPickHour() * 60 + orderSaveVo.getPickMinute()) {
                return ResultMessage.DataError;
            } else if (userDataService.getUserByWechatId(orderSaveVo.getWechatId()).getFaithlessTime() > 3) {
                throw new UserDoesNotFaithException();
            }
        }
        return orderDataService.saveOrder(Convertor.orderSaveVoToOrder(orderSaveVo));
    }

    /**
     * confirm whether the user has orders to be confirmed
     *
     * @param wechatId the user to be queried
     * @return whether the user has unconfirmed orders
     */
    @Override
    public boolean hasUnconfirmedOrder(String wechatId) {
        return orderDataService.hasUnconfirmedOrder(wechatId);
    }

    /**
     * get the all orders of the user
     *
     * @param wechatId the user to be queried
     * @return the list of the orders
     */
    @Override
    public List<OrderReturnVo> getOrderByUser(String wechatId) {
        ArrayList<OrderReturnVo> orderReturnVoArrayList = new ArrayList<>();
        List<Order> orderArrayList = orderDataService.getOrderByUser(wechatId);
        for (Order order : orderArrayList) {
            orderReturnVoArrayList.add(Convertor.orderToOrderReturnVo(order));
        }
        return orderReturnVoArrayList;
    }

    /**
     * confirm the selected order
     *
     * @param orderId the order to be confirmed
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage confirmOrder(int orderId) {
        return orderDataService.confirmOrder(orderId);
    }

    /**
     * delete the selected order
     *
     * @param orderId the order to be deleted
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteOrder(int orderId) {
        return orderDataService.deleteOrder(orderId);
    }
}
