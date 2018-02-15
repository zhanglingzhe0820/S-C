package cn.s_c.dataservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantDataService {

    /**
     * get the restaurant object by its id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    Restaurant getRestaurantById(int restaurantId);
}
