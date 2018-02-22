package cn.s_c.data.supplier;

import cn.s_c.dataservice.suppiler.SupplierDataService;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierDataServiceImplTest {

    @Autowired
    SupplierDataService supplierDataService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    public void saveSupplierInfo() {
        Supplier supplier = new Supplier("123", "123", "123", 1, null);
        assertEquals(ResultMessage.Success, supplierDataService.saveSupplierInfo(supplier));
    }

    @Test
    @Transactional
    public void isUsernameExisted() {
        Supplier supplier = new Supplier("123", "123", "123", 1, null);
        supplierDataService.saveSupplierInfo(supplier);
        assertEquals(true, supplierDataService.isUsernameExisted("123"));
    }

    @Test
    @Transactional
    public void getPasswordByUsername() {
        Supplier supplier = new Supplier("123", "123", "123", 1, null);
        supplierDataService.saveSupplierInfo(supplier);
        assertEquals("123", supplierDataService.getPasswordByUsername("123"));
    }
}