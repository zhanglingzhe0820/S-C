package cn.s_c.data.dao.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

    Restaurant findRestaurantByName(String name);
}
