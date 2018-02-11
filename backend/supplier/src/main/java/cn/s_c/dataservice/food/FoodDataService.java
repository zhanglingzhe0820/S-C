package cn.s_c.dataservice.food;

import cn.s_c.entity.food.Food;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface FoodDataService {
    /**
     * get the food in the restaurant
     *
     * @param restaurantId the target restaurant
     * @return the list of food
     */
    Set<Food> getFoodListByRestaurant(int restaurantId);

    /**
     * get the number of the food already ordered
     * @param foodId the food id
     * @return the num of the food ordered
     */
    double getFoodAlreadyOrdered(int foodId);
}
