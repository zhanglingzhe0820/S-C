package cn.s_c.dataservice.food;

import cn.s_c.entity.food.Food;
import cn.s_c.vo.ResultMessage;
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
     *
     * @param foodId the food id
     * @return the num of the food ordered
     */
    double getFoodAlreadyOrdered(int foodId);

    /**
     * get food object by id
     *
     * @param foodId the food id
     * @return the food object
     */
    Food getFoodById(int foodId);

    /**
     * add the foods to database
     *
     * @param foods the array of food
     * @return whether the operation is success or not
     */
    ResultMessage addFoodsToShelf(Food[] foods);

    /**
     * remove the foods from database
     *
     * @param restaurantId the id of the restaurant
     * @param positionName the name of the position
     * @return whether the operation is success or not
     */
    ResultMessage removeFoodFromShelf(int restaurantId, String positionName);
}
