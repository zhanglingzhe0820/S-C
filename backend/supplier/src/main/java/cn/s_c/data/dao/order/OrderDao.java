package cn.s_c.data.dao.order;

import cn.s_c.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
