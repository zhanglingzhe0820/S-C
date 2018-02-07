package cn.s_c.data.dao.order;

import cn.s_c.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findOrdersByIsConfirmed(boolean isConfirmed);

    List<Order> findOrdersByWechatId(String wechatId);
}
