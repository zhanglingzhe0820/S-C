package cn.s_c.data.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.data.dao.order.OrderDao;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.vo.order.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    @Autowired
    private OrderDao orderDao;

    /**
     * get all of the orders
     *
     * @return the order list
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }
}
