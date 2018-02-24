package cn.s_c.springcontroller.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.vo.ResultMessage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    private FoodBlService foodBlService;

    @ApiOperation(value = "publishFoods", nickname = "publishFoods")
    @RequestMapping(method = RequestMethod.POST, path = "/publishFoods", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage publishFoods(@RequestParam(name = "supplierFoodIds") int[] supplierFoodIds, @RequestParam(name = "maximum") double maximum, @RequestParam(name = "endHour") int endHour, @RequestParam(name = "endMinute") int endMinute) {
        return foodBlService.publishFoods(supplierFoodIds, maximum, endHour, endMinute);
    }

    @ApiOperation(value = "shelfOffFoods", nickname = "shelfOffFoods")
    @RequestMapping(method = RequestMethod.POST, path = "/shelfOffFoods", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage shelfOffFoods(@RequestParam(name = "supplierUsername") String supplierUsername) {
        return foodBlService.shelfOffFoods(supplierUsername);
    }
}
