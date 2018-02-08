package cn.s_c.dataservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantDataService {
    /**
     * get all the restaurant
     *
     * @return the list of restaurants
     */
    List<Restaurant> getRestaurantList();
}
