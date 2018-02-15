package cn.s_c.dataservice.food;

import cn.s_c.entity.food.Food;
import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

@Service
public interface FoodDataService {

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
