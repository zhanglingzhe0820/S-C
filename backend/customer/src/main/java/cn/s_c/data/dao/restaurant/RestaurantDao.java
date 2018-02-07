package cn.s_c.data.dao.restaurant;

import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
}
