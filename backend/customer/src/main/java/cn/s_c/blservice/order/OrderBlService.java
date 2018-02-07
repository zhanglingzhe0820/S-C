package cn.s_c.blservice.order;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import cn.s_c.vo.user.UserConfirmVo;
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
}
