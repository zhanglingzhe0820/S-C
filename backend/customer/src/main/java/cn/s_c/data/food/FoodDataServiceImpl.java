package cn.s_c.data.food;

import cn.s_c.data.dao.order.OrderDao;
import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.order.FoodOrder;
import cn.s_c.entity.order.Order;
import cn.s_c.entity.restaurant.Restaurant;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FoodDataServiceImpl implements FoodDataService {
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    OrderDao orderDao;

    /**
     * get the food in the restaurant
     *
     * @param restaurantId the target restaurant
     * @return the list of food
     */
    @Override
    public Set<Food> getFoodListByRestaurant(int restaurantId) {
        try {
            Restaurant restaurant = restaurantDao.getOne(restaurantId);
            return restaurant.getFoods();
        }catch (EntityNotFoundException e){
            return new HashSet<Food>();
        }
    }

    /**
     * get the number of the food already ordered
     *
     * @param foodId the food id
     * @return the num of the food ordered
     */
    @Override
    public double getFoodAlreadyOrdered(int foodId) {
        List<Order> orderList=orderDao.findOrdersByIsConfirmed(false);
        double total=0;
        for(Order order:orderList){
            for(FoodOrder foodOrder:order.getFoodList()){
                if(foodOrder.getFood().getId()==foodId){
                    total+= foodOrder.getNum();
                }
            }
        }
        return total;
    }
}
