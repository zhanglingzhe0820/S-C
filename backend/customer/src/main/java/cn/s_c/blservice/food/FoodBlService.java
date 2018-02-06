package cn.s_c.blservice.food;

import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodBlService {
    /**
     * get the food in the restaurant
     *
     * @param restaurantId the target restaurant
     * @return the list of food
     */
    List<Food> getFoodListByRestaurant(String restaurantId);


}
