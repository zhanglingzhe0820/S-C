package cn.s_c.bl.restaurant;

import cn.s_c.blservice.restaurant.RestaurantBlService;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.util.Convertor;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantBlServiceImpl implements RestaurantBlService {
    @Autowired
    RestaurantDataService restaurantDataService;
    /**
     * get the restaurant name and id
     *
     * @return the list of restaurant with id and name
     */
    @Override
    public List<RestaurantReturnVo> getRestaurantNameAndIdList() {
        List<Restaurant> restaurantList=restaurantDataService.getRestaurantList();
        List<RestaurantReturnVo> restaurantReturnVoList=new ArrayList<>();
        for(Restaurant restaurant:restaurantList){
            restaurantReturnVoList.add(Convertor.restaurantToRestaurantReturnVo(restaurant));
        }
        return restaurantReturnVoList;
    }
}
