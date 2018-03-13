package cn.s_c.dataservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.ResultMessage;
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

    /**
     * get the restaurant object by its id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    Restaurant getRestaurantById(int restaurantId);

    /**
     * is the name of restaurant existed
     *
     * @param name the name of the restaurant
     * @return whether the name exists
     */
    boolean isNameExisted(String name);

    /**
     * save restaurant
     *
     * @param restaurant the restaurant to be saved
     * @return whether the operation is success or not
     */
    ResultMessage saveRestaurant(Restaurant restaurant);

    /**
     * get all restaurants
     *
     * @return the list of restaurants
     */
    List<Restaurant> getAllRestaurants();
}
