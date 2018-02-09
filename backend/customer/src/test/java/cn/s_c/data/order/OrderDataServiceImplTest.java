package cn.s_c.data.order;

import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.entity.order.FoodOrder;
import cn.s_c.entity.order.Order;
import cn.s_c.vo.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional
    @Rollback(false)
    public void originSaveAndDelete() {
        FoodOrder foodOrder = new FoodOrder(1, "包子", "大众美食", 2, "至善楼一楼", 1);
        List<FoodOrder> foodOrderList = new ArrayList<>();
        foodOrderList.add(foodOrder);
        Order order = new Order("123", foodOrderList, 3, 0.5, 11, 20, "123", false);
        assertEquals(ResultMessage.Success, orderDataService.saveOrder(order));
        assertEquals(2, orderDataService.getOrderByUser("123").get(0).getFoodList().get(0).getPrice(), 0.1);
    }

    @Test
    public void hasUnconfirmedOrder() {
        FoodOrder foodOrder = new FoodOrder(1, "包子", "大众美食", 2, "至善楼一楼", 1);
        List<FoodOrder> foodOrderList = new ArrayList<>();
        foodOrderList.add(foodOrder);
        Order order = new Order("123", foodOrderList, 3, 0.5, 11, 20, "123", false);
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
        FoodOrder foodOrder = new FoodOrder(1, "包子", "大众美食", 2, "至善楼一楼", 1);
        List<FoodOrder> foodOrderList = new ArrayList<>();
        foodOrderList.add(foodOrder);
        Order order = new Order("123", foodOrderList, 3, 0.5, 11, 20, "123", false);
        assertEquals(ResultMessage.Success, orderDataService.saveOrder(order));
        int orderId = orderDataService.getOrderByUser("123").get(0).getId();
        orderDataService.confirmOrder(orderId);
        assertEquals(false, orderDataService.hasUnconfirmedOrder("123"));
        orderDataService.deleteOrder(orderId);
    }
}