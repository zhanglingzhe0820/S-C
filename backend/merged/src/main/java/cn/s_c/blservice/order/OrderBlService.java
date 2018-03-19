package cn.s_c.blservice.order;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderList;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderBlService {

    /**
     * save the order
     *
     * @param orderSaveVo the order to be saved
     * @return whether the operation is success or not
     */
    ResultMessage saveOrder(OrderSaveVo orderSaveVo);

    /**
     * confirm whether the user has orders to be confirmed
     *
     * @param wechatId the user to be queried
     * @return whether the user has unconfirmed orders
     */
    boolean hasUnconfirmedOrder(String wechatId);

    /**
     * get the all orders of the user
     *
     * @param wechatId the user to be queried
     * @return the list of the orders
     */
    List<OrderReturnVo> getOrderByUser(String wechatId);

    /**
     * confirm the selected order
     *
     * @param orderId the order to be confirmed
     * @return whether the operation is success or not
     */
    ResultMessage confirmOrder(int orderId);

    /**
     * delete the selected order
     *
     * @param orderId the order to be deleted
     * @return whether the operation is success or not
     */
    ResultMessage deleteOrder(int orderId);

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
    OrderList[] getOrders(String supplierUsername, int startHour, int startMinute, int endHour, int endMinute);
}
