package cn.s_c.data.food;

import cn.s_c.dataservice.food.SupplierFoodDataService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierFoodDataServiceImplTest {
    @Autowired
    private SupplierFoodDataService supplierFoodDataService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void uploadImageToCloud() {
        assertEquals("", supplierFoodDataService.uploadImageToCloud(null));
    }

    @Test
    public void saveSupplierFood() {
    }

    @Test
    public void getSupplierFoodBySupplierUsername() {
    }

    @Test
    public void deleteSupplierFood() {
    }
}