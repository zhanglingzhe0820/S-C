package cn.s_c.bl.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.vo.order.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBlServiceImpl implements OrderBlService {
    @Autowired
    private OrderDataService orderDataService;

    /**
     * get the orders by username
     *
     * @param supplierUsername the username of the supplier
     * @return the list of orders
     */
    @Override
    public OrderList[] getOrders(String supplierUsername) {
        
        List<Order> orderList = orderDataService.getAllOrders();
        List<OrderList> orderListList = new ArrayList<>();
        for (Order order : orderList) {

        }
        return new OrderList[0];
    }
}
