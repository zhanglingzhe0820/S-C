package cn.s_c.data.restaurant;

import cn.s_c.data.dao.restaurant.RestaurantDao;
import cn.s_c.dataservice.food.FoodDataService;
import cn.s_c.dataservice.restaurant.RestaurantDataService;
import cn.s_c.entity.food.Food;
import cn.s_c.entity.restaurant.Restaurant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantDataServiceImplTest {

    @Autowired
    RestaurantDataService restaurantDataService;
    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    FoodDataService foodDataService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    @Rollback(false)
    public void getRestaurantList() {
        String[] choice={"加辣","不加辣"};
        Restaurant restaurant=new Restaurant("致善楼一楼","12.00-2.00",null);
        Food food1=new Food("包子","大众美食",1,"http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",100,true,choice,restaurant);
        Food food2=new Food("馒头","大众美食",2,"http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",100,true,choice,restaurant);
        Set<Food> foodSet=new HashSet<Food>();
        foodSet.add(food1);
        foodSet.add(food2);
        restaurant.setFoods(foodSet);
        restaurantDao.save(restaurant);
        System.out.println(foodDataService.getFoodListByRestaurant(restaurant.getId()).iterator().next().getChoice()[0]);
    }
}