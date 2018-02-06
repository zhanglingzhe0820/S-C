package cn.s_c.bl.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBlServiceImpl implements OrderBlService {

    /**
     * save the order
     *
     * @param orderSaveVo the order to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveOrder(OrderSaveVo orderSaveVo) {
        return null;
    }

    /**
     * confirm whether the user has orders to be confirmed
     *
     * @param wechatId the user to be queried
     * @return whether the user has unconfirmed orders
     */
    @Override
    public boolean hasUnconfirmedOrder(String wechatId) {
        return false;
    }

    /**
     * get the all orders of the user
     *
     * @param wechatId the user to be queried
     * @return the list of the orders
     */
    @Override
    public List<OrderReturnVo> getOrderByUser(String wechatId) {
        return null;
    }

    /**
     * confirm the selected order
     *
     * @param orderId the order to be confirmed
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage confirmOrder(String orderId) {
        return null;
    }

    /**
     * delete the selected order
     *
     * @param orderId the order to be deleted
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteOrder(String orderId) {
        return null;
    }
}
