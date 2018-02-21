package cn.s_c.springcontroller.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import cn.s_c.vo.restaurant.RestaurantSaveVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantBlService restaurantBlService;

    @ApiOperation(value = "saveRestaurant", nickname = "saveRestaurant")
    @RequestMapping(method = RequestMethod.GET, path = "/saveRestaurant", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage saveRestaurant(@RequestParam("name") String name, @RequestParam("time") String time) {
        return restaurantBlService.saveRestaurant(new RestaurantSaveVo(name, time));
    }

    @ApiOperation(value = "loadRestaurant", nickname = "loadRestaurant")
    @RequestMapping(method = RequestMethod.GET, path = "/loadRestaurant", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = RestaurantReturnVo[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public RestaurantReturnVo[] loadRestaurant() {
        return restaurantBlService.loadRestaurants();
    }
}
