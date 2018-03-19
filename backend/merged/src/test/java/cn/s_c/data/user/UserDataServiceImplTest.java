package cn.s_c.data.user;

import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.vo.ResultMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataServiceImplTest {
    @Autowired
    UserDataService userDataService;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isNumberExisted() {
        assertEquals(false, userDataService.isNumberExisted("123"));
    }

    @Test
    public void bindWechatIdAndNumber() {
        assertEquals(ResultMessage.Success, userDataService.bindWechatIdAndNumber("456", "456", true));
    }

    @Test
    public void getUserStateByWechat() {
        assertEquals(false, userDataService.getUserStateByWechat("789").isAuthened());
        assertEquals(false, userDataService.getUserStateByWechat("789").isStudent());
        assertEquals(true, userDataService.getUserStateByWechat("456").isAuthened());
        assertEquals(true, userDataService.getUserStateByWechat("456").isStudent());
    }
}