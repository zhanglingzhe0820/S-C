package cn.s_c.data.order;

import cn.s_c.data.dao.order.OrderDao;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Autowired
    private OrderDao orderDao;

    /**
     * save the order
     *
     * @param order the order to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveOrder(Order order) {
        if (orderDao.save(order) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }

    /**
     * confirm whether the user has orders to be confirmed
     *
     * @param wechatId the user to be queried
     * @return whether the user has unconfirmed orders
     */
    @Override
    public boolean hasUnconfirmedOrder(String wechatId) {
        return orderDao.findOrdersByIsConfirmed(false).size() != 0;
    }

    /**
     * get the all orders of the user
     *
     * @param wechatId the user to be queried
     * @return the list of the orders
     */
    @Override
    public List<Order> getOrderByUser(String wechatId) {
        return orderDao.findOrdersByWechatId(wechatId);
    }

    /**
     * confirm the selected order
     *
     * @param orderId the order to be confirmed
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage confirmOrder(int orderId) {
        Order order = orderDao.findOne(orderId);
        order.setConfirmed(true);
        if (orderDao.save(order) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }

    /**
     * delete the selected order
     *
     * @param orderId the order to be deleted
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteOrder(int orderId) {
        orderDao.delete(orderId);
        return ResultMessage.Success;
    }

    /**
     * get all of the orders
     *
     * @return the order list
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    /**
     * get all confirmed orders
     *
     * @return the order list
     */
    @Override
    public List<Order> getUnconfirmedOrders() {
        return orderDao.findOrdersByIsConfirmed(false);
    }
}
