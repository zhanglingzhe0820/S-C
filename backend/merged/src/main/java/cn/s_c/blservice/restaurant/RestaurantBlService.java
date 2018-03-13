package cn.s_c.blservice.restaurant;

import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import cn.s_c.vo.restaurant.RestaurantSaveVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantBlService {
    /**
     * get the restaurant name and id
     *
     * @return the list of restaurant with id and name
     */
    List<RestaurantReturnVo> getRestaurantNameAndIdList();

    /**
     * get the restaurant object by the restaurant's id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    Restaurant getRestaurantObjectByRestaurantId(int restaurantId);

    /**
     * save restaurant
     *
     * @param restaurantSaveVo the restaurant to be saved
     * @return whether the operation is success or not
     */
    ResultMessage saveRestaurant(RestaurantSaveVo restaurantSaveVo);

    /**
     * load restaurants
     *
     * @return the restaurant id and name to return
     */
    RestaurantReturnVo[] loadRestaurants();
}
