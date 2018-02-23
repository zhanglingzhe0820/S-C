package cn.s_c.dataservice.order;

import cn.s_c.entity.order.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDataService {
    /**
     * get all of the orders
     *
     * @return the order list
     */
    List<Order> getAllOrders();
}
