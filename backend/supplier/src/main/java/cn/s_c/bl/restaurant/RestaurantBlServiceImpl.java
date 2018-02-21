package cn.s_c.bl.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import cn.s_c.vo.restaurant.RestaurantSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantBlServiceImpl implements RestaurantBlService {
    @Autowired
    private RestaurantDataService restaurantDataService;

    /**
     * get the restaurant object by the restaurant's id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    @Override
    public Restaurant getRestaurantObjectByRestaurantId(int restaurantId) {
        return restaurantDataService.getRestaurantById(restaurantId);
    }

    /**
     * save restaurant
     *
     * @param restaurantSaveVo the restaurant to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveRestaurant(RestaurantSaveVo restaurantSaveVo) {
        if (restaurantDataService.isNameExisted(restaurantSaveVo.getName())) {
            return ResultMessage.DataError;
        } else {
            return restaurantDataService.saveRestaurant(Convertor.restaurantSaveVoToRestaurant(restaurantSaveVo));
        }
    }

    /**
     * load restaurants
     *
     * @return the restaurant id and name to return
     */
    @Override
    public RestaurantReturnVo[] loadRestaurants() {
        List<Restaurant> restaurantList = restaurantDataService.getAllRestaurants();
        RestaurantReturnVo[] restaurantReturnVos = new RestaurantReturnVo[restaurantList.size()];
        for (int i = 0; i < restaurantList.size(); i++) {
            restaurantReturnVos[i] = Convertor.restaurantToRestaurantReturnVo(restaurantList.get(i));
        }
        return restaurantReturnVos;
    }
}
