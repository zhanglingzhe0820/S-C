package cn.s_c.data.food;

import cn.s_c.data.dao.food.FoodDao;
import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    @Autowired
    private FoodDao foodDao;
    @Autowired
    private RestaurantDao restaurantDao;

    /**
     * add the foods to database
     *
     * @param foods the array of food
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage addFoodsToShelf(Food[] foods) {
        try {
            for (Food food : foods) {
                foodDao.save(food);
            }
            return ResultMessage.Success;
        } catch (Exception e) {
            return ResultMessage.SystemError;
        }
    }

    /**
     * remove the foods from database
     *
     * @param restaurantId the id of the restaurant
     * @param positionName the name of the position
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage removeFoodFromShelf(int restaurantId, String positionName) {
        try {
            Restaurant restaurant = restaurantDao.findOne(restaurantId);
            Set<Food> foodSet = restaurant.getFoods();
            for (Food food : foodSet) {
                if (food.getPosition().equals(positionName)) {
                    foodDao.delete(food.getId());
                }
            }
            return ResultMessage.Success;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMessage.SystemError;
        }
    }
}
