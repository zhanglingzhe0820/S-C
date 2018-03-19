package cn.s_c.springcontroller.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import cn.s_c.vo.restaurant.RestaurantSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantBlService restaurantBlService;

    @RequestMapping(method = RequestMethod.GET, path = "/getRestaurantNameAndIdList", produces = "application/json")
    @ResponseBody
    public RestaurantReturnVo[] getRestaurantNameAndIdList() {
        List<RestaurantReturnVo> restaurantReturnVoList = restaurantBlService.getRestaurantNameAndIdList();
        return restaurantReturnVoList.toArray(new RestaurantReturnVo[restaurantReturnVoList.size()]);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/saveRestaurant", produces = "application/json")
    @ResponseBody
    public ResultMessage saveRestaurant(@RequestParam("name") String name, @RequestParam("time") String time) {
        return restaurantBlService.saveRestaurant(new RestaurantSaveVo(name, time));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/loadRestaurant", produces = "application/json")
    @ResponseBody
    public RestaurantReturnVo[] loadRestaurant() {
        return restaurantBlService.loadRestaurants();
    }
}
