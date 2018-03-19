package cn.s_c.data.food;

import cn.s_c.dataservice.food.FoodDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodDataServiceImplTest {
    @Autowired
    FoodDataService foodDataService;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Transactional
    public void getFoodListByRestaurant() {
        assertEquals(0, foodDataService.getFoodListByRestaurant(123).size());
    }
}