package cn.s_c.dataservice.user;

import cn.s_c.entity.user.User;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface UserDataService {
    /**
     * watch whether the number exists
     *
     * @param number student or teacher number
     * @return the number exists or not
     */
    @Transactional
    boolean isNumberExisted(String number);

    /**
     * bind the wechat id and student or teacher number
     *
     * @param wechatId  wechat id
     * @param number    student or teacher number
     * @param isStudent whether the number is a student id
     * @return the operation is success or not
     */
    @Transactional
    ResultMessage bindWechatIdAndNumber(String wechatId, String number, boolean isStudent);

    /**
     * get the user's state by its wechat id
     *
     * @param wechatId wechat id
     * @return the user's state
     */
    @Transactional
    UserConfirmVo getUserStateByWechat(String wechatId);

    /**
     * get all users
     *
     * @return
     */
    @Transactional
    List<User> getUsers();

    /**
     * get user by wechat id
     *
     * @param wechatId wechat id
     * @return the user object
     */
    @Transactional
    User getUserByWechatId(String wechatId);
}
