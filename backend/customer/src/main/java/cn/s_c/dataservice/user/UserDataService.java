package cn.s_c.dataservice.user;

import cn.s_c.entity.user.User;
import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface UserDataService {
    /**
     * judge whether the user exists
     *
     * @param number student number
     * @return exists or not
     */
    @Transactional
    boolean isUserExisted(String number);

    /**
     * get user by number
     *
     * @param number student number
     * @return the user who has the number
     */
    @Transactional
    User getUserByNumber(String number);

    /**
     * insert the user class
     *
     * @param user the input user
     * @return whether the operation is success or not
     */
    @Transactional
    ResultMessage insertUser(User user);

    /**
     * delete a user
     * @param number student number
     * @return whether the operation is success or not
     */
    @Transactional
    ResultMessage deleteUser(String number);
}
