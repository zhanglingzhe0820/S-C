package cn.s_c.data.order;

import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.vo.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDataServiceImplTest {
    @Autowired
    private OrderDataService orderDataService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void originSaveAndDelete() {
        Order order = new Order("123", null, 10, 0.5, false);
        assertEquals(ResultMessage.Success, orderDataService.saveOrder(order));
        assertEquals(10, orderDataService.getOrderByUser("123").get(0).getCommodityTotal(), 0.1);
        int orderId = orderDataService.getOrderByUser("123").get(0).getId();
        orderDataService.deleteOrder(orderId);
    }

    @Test
    public void hasUnconfirmedOrder() {
        Order order = new Order("123", null, 10, 0.5, false);
        assertEquals(ResultMessage.Success, orderDataService.saveOrder(order));
        assertEquals(true, orderDataService.hasUnconfirmedOrder("123"));
        int orderId = orderDataService.getOrderByUser("123").get(0).getId();
        orderDataService.deleteOrder(orderId);
    }

    @Test
    public void noOrderTest() {
        assertEquals(false, orderDataService.hasUnconfirmedOrder("123"));
    }

    @Test
    public void commonConfirmOrder() {
        Order order = new Order("123", null, 10, 0.5, false);
        assertEquals(ResultMessage.Success, orderDataService.saveOrder(order));
        int orderId = orderDataService.getOrderByUser("123").get(0).getId();
        orderDataService.confirmOrder(orderId);
        assertEquals(false, orderDataService.hasUnconfirmedOrder("123"));
        orderDataService.deleteOrder(orderId);
    }
}