package cn.s_c.blservice.food;

import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.food.FoodReturnVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface FoodBlService {
    /**
     * get the food in the restaurant
     *
     * @param restaurantId the target restaurant
     * @return the list of food
     */
    List<FoodReturnVo> getFoodListByRestaurant(int restaurantId);
}
