package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.FoodReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodConrtroller {

    @Autowired
    private FoodBlService foodBlService;

    @RequestMapping(method = RequestMethod.POST, path = "/getFoodListByRestaurant", produces = "application/json")
    @ResponseBody
    public FoodReturnVo[] getFoodListByRestaurant(@RequestParam("restaurantId") int restaurantId) {
        List<FoodReturnVo> foodReturnVoList = foodBlService.getFoodListByRestaurant(restaurantId);
        return foodReturnVoList.toArray(new FoodReturnVo[foodReturnVoList.size()]);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/publishFoods", produces = "application/json")
    @ResponseBody
    public ResultMessage publishFoods(@RequestParam(name = "supplierFoodIds") int[] supplierFoodIds, @RequestParam(name = "maximum") double maximum, @RequestParam(name = "endHour") int endHour, @RequestParam(name = "endMinute") int endMinute) {
        return foodBlService.publishFoods(supplierFoodIds, maximum, endHour, endMinute);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/shelfOffFoods", produces = "application/json")
    @ResponseBody
    public ResultMessage shelfOffFoods(@RequestParam(name = "supplierUsername") String supplierUsername) {
        return foodBlService.shelfOffFoods(supplierUsername);
    }
}
