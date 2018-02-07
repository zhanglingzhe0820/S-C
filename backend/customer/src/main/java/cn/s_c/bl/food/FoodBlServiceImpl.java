package cn.s_c.bl.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.food.FoodReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FoodBlServiceImpl implements FoodBlService {
    @Autowired
    private FoodDataService foodDataService;

    /**
     * get the food in the restaurant
     *
     * @param restaurantId the target restaurant
     * @return the list of food
     */
    public List<FoodReturnVo> getFoodListByRestaurant(int restaurantId) {
        List<FoodReturnVo> foodReturnVoList = new ArrayList<>();
        Set<Food> foodList = foodDataService.getFoodListByRestaurant(restaurantId);
        for (Food food : foodList) {
            FoodReturnVo foodReturnVo = new FoodReturnVo(food.getId(), food.getName(), food.getPosition(), food.getPrice(), food.getUrl(), food.getMaximum(), food.getRestaurant(), foodDataService.getFoodAlreadyOrdered(food.getId()));
            foodReturnVoList.add(foodReturnVo);
        }
        return foodReturnVoList;
    }
}
