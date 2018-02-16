package cn.s_c.bl.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.FoodPublishVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodBlServiceImpl implements FoodBlService {
    @Autowired
    private FoodDataService foodDataService;
    @Autowired
    private RestaurantBlService restaurantBlService;

    /**
     * publish the foods
     *
     * @param foodPublishVos the foods to be published
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage publishFoods(FoodPublishVo[] foodPublishVos) {
        List<Food> foodList = new ArrayList<>();
        for (FoodPublishVo foodPublishVo : foodPublishVos) {
            Food food = new Food(foodPublishVo.getName(), foodPublishVo.getPosition(), foodPublishVo.getPrice(), foodPublishVo.getUrl(), foodPublishVo.getMaximum(), foodPublishVo.isHasChoice(), foodPublishVo.getChoice(), restaurantBlService.getRestaurantObjectByRestaurantId(foodPublishVo.getRestaurantId()));
        }
        return foodDataService.addFoodsToShelf(foodList.toArray(new Food[foodList.size()]));
    }

    /**
     * shelf off the foods
     *
     * @param restaurantId the id of the restaurant
     * @param positionName the name of the position
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage shelfOffFoods(int restaurantId, String positionName) {
        return foodDataService.removeFoodFromShelf(restaurantId, positionName);
    }
}
