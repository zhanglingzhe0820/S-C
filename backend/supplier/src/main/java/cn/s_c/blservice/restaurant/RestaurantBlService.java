package cn.s_c.blservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantBlService {

    /**
     * get the restaurant object by the restaurant's id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    Restaurant getRestaurantObjectByRestaurantId(int restaurantId);
}
