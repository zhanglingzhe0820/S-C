package cn.s_c.blservice.order;

import cn.s_c.vo.order.OrderList;
import org.springframework.stereotype.Service;

@Service
public interface OrderBlService {

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
