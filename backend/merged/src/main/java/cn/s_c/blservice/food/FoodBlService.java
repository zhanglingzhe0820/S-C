package cn.s_c.blservice.food;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.FoodReturnVo;
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
    List<FoodReturnVo> getFoodListByRestaurant(int restaurantId);

    /**
     * publish the foods
     *
     * @param supplierFoodIds the ids of foods to be published
     * @param maximum         the maximum of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage publishFoods(int[] supplierFoodIds, double maximum, int endHour, int endMinute);

    /**
     * shelf off the foods
     *
     * @param supplierUsername the username of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage shelfOffFoods(String supplierUsername);
}
