package cn.s_c.blservice.user;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserAuthenVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.stereotype.Service;

@Service
public interface UserBlService {
    /**
     * authen user
     * @param userAuthenVo the user info to be register
     * @return whether the operation is success or not
     */
    ResultMessage authen(UserAuthenVo userAuthenVo);

    /**
     * get the state od the user
     * @param wechatId the user's openid
     * @return the state of the user
     */
    UserConfirmVo confirmState(String wechatId);

}
