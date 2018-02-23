package cn.s_c.blservice.order;

import cn.s_c.vo.order.OrderList;
import org.springframework.stereotype.Service;

@Service
public interface OrderBlService {

    /**
     * get the orders by username
     *
     * @param supplierUsername the username of the supplier
     * @return the list of orders
     */
    OrderList[] getOrders(String supplierUsername);
}
