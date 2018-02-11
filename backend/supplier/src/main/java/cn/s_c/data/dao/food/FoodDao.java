package cn.s_c.data.dao.food;

import cn.s_c.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FoodDao extends JpaRepository<Food, Integer> {

}
