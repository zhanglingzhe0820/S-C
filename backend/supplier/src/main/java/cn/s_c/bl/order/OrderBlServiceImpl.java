package cn.s_c.bl.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBlServiceImpl implements OrderBlService {
    @Autowired
    private OrderDataService orderDataService;

    /**
     * save the order
     *
     * @param orderSaveVo the order to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveOrder(OrderSaveVo orderSaveVo) {
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
