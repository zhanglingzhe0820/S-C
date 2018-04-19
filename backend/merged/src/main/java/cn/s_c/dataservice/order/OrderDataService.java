package cn.s_c.dataservice.order;

import cn.s_c.entity.order.Order;
import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDataService {

    /**
     * save the order
     *
     * @param order the order to be saved
     * @return whether the operation is success or not
     */
    ResultMessage saveOrder(Order order);

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
    List<Order> getOrderByUser(String wechatId);

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
     * get all of the orders
     *
     * @return the order list
     */
    List<Order> getAllOrders();

    /**
     * get all confirmed orders
     *
     * @return the order list
     */
    List<Order> getUnconfirmedOrders();
}
