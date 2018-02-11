package cn.s_c.data.restaurant;

import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantDataServiceImpl implements RestaurantDataService {
    @Autowired
    RestaurantDao restaurantDao;

    /**
     * get all the restaurant
     *
     * @return the list of restaurants
     */
    @Override
    public List<Restaurant> getRestaurantList() {
        return restaurantDao.findAll();
    }
}
