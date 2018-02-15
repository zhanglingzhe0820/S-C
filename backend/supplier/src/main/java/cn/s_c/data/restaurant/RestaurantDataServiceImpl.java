package cn.s_c.data.restaurant;

import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantDataServiceImpl implements RestaurantDataService {
    @Autowired
    private RestaurantDao restaurantDao;

    /**
     * get the restaurant object by its id
     *
     * @param restaurantId the id of the restaurant
     * @return the restaurant object
     */
    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        return restaurantDao.findOne(restaurantId);
    }
}
