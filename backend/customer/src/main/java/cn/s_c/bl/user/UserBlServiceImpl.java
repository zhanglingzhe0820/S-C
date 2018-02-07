package cn.s_c.bl.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserAuthenVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlServiceImpl implements UserBlService {

    @Autowired
    private UserDataService userDataService;

    /**
     * authen user
     *
     * @param userAuthenVo the user info to be register
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage authen(UserAuthenVo userAuthenVo) {
        if (userDataService.isNumberExisted(userAuthenVo.getNumber())) {
            return ResultMessage.DataError;
        } else {
            boolean isStudent = true;
            return userDataService.bindWechatIdAndNumber(userAuthenVo.getWechatId(), userAuthenVo.getNumber(), isStudent);
        }
    }

    /**
     * get the state of the user
     *
     * @param wechatId the user's openid
     * @return the state of the user
     */
    @Override
    public UserConfirmVo confirmState(String wechatId) {
        return userDataService.getUserStateByWechat(wechatId);
    }
}
