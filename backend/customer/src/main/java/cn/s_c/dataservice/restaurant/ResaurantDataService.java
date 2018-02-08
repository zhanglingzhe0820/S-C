package cn.s_c.dataservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;

import java.util.List;

public interface ResaurantDataService {
    /**
     * get all the restaurant
     *
     * @return the list of restaurants
     */
    List<Restaurant> getRestaurantList();
}
