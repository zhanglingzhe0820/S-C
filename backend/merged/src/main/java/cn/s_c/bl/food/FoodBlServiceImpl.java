package cn.s_c.bl.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.dataservice.suppiler.SupplierDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
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
    @Autowired
    private SupplierFoodDataService supplierFoodDataService;
    @Autowired
    private SupplierDataService supplierDataService;
    @Autowired
    private RestaurantBlService restaurantBlService;

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
            FoodReturnVo foodReturnVo = new FoodReturnVo(food.getId(), food.getName(), food.getPosition(), food.getPrice(), food.getUrl(), food.getMaximum(), food.isHasChoice(), food.getChoice(), Convertor.restaurantToRestaurantReturnVo(food.getRestaurant()), foodDataService.getFoodAlreadyOrdered(food.getId()));
            foodReturnVoList.add(foodReturnVo);
        }
        return foodReturnVoList;
    }

    /**
     * publish the foods
     *
     * @param supplierFoodIds the ids of foods to be published
     * @param maximum         the maximum of the supplier
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage publishFoods(int[] supplierFoodIds, double maximum, int endHour, int endMinute) {
        List<Food> foodList = new ArrayList<>();
        for (int supplierFoodId : supplierFoodIds) {
            SupplierFood supplierFood = supplierFoodDataService.getSupplierFoodById(supplierFoodId);
            Food food = new Food(supplierFood.getName(), supplierFood.getSupplier().getName(), supplierFood.getPrice(), supplierFood.getUrl(), maximum, supplierFood.isHasChoice(), supplierFood.getChoice(), endHour, endMinute, restaurantBlService.getRestaurantObjectByRestaurantId(supplierFood.getSupplier().getRestaurantId()));
            foodList.add(food);
        }
        return foodDataService.addFoodsToShelf(foodList.toArray(new Food[foodList.size()]));
    }

    /**
     * shelf off the foods
     *
     * @param supplierUsername the username of the supplier
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage shelfOffFoods(String supplierUsername) {
        Supplier supplier = supplierDataService.getSupplierByUsername(supplierUsername);
        return foodDataService.removeFoodFromShelf(supplier.getRestaurantId(), supplier.getName());
    }
}
