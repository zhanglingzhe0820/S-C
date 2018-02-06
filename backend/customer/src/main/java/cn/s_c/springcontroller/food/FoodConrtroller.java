package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.entity.food.Food;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodConrtroller {

    @Autowired
    private FoodBlService foodBlService;

    @ApiOperation(value = "getFoodListByRestaurant", nickname = "getFoodListByRestaurant")
    @RequestMapping(method = RequestMethod.GET, path = "/getFoodListByRestaurant", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Food[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public Food[] getFoodListByRestaurant(@RequestBody String restaurantId) {
        List<Food> foodList = foodBlService.getFoodListByRestaurant(restaurantId);
        return foodList.toArray(new Food[foodList.size()]);
    }
}
