package cn.s_c.data.dao.food;

import cn.s_c.entity.food.SupplierFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SupplierFoodDao extends JpaRepository<SupplierFood, Integer> {
}
