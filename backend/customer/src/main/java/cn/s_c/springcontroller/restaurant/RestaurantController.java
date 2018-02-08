package cn.s_c.springcontroller.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantBlService restaurantBlService;

    @ApiOperation(value = "getRestaurantNameAndIdList", nickname = "getRestaurantNameAndIdList")
    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantNameAndIdList", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = RestaurantReturnVo[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public RestaurantReturnVo[] getRestaurantNameAndIdList() {
        List<RestaurantReturnVo> restaurantReturnVoList = restaurantBlService.getRestaurantNameAndIdList();
        return restaurantReturnVoList.toArray(new RestaurantReturnVo[restaurantReturnVoList.size()]);
    }
}
