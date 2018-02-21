package cn.s_c.data.restaurant;

import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.ResultMessage;
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

    /**
     * is the name of restaurant existed
     *
     * @param name the name of the restaurant
     * @return whether the name exists
     */
    @Override
    public boolean isNameExisted(String name) {
        return restaurantDao.findRestaurantByName(name) != null;
    }

    /**
     * save restaurant
     *
     * @param restaurant the restaurant to be saved
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveRestaurant(Restaurant restaurant) {
        if (restaurantDao.save(restaurant) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }
}
