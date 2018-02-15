package cn.s_c.bl.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantBlServiceImpl implements RestaurantBlService {
    /**
     * get the restaurant object by the restaurant's id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    @Override
    public Restaurant getRestaurantObjectByRestaurantId(int restaurantId) {
        return null;
    }
}
