package cn.s_c.data.user;

import cn.s_c.data.dao.user.UserDao;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.entity.user.User;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private UserDao userDao;


    /**
     * judge whether the user exists
     *
     * @param number student number
     * @return exists or not
     */
    @Override
    @Transactional
    public boolean isUserExisted(String number) {
        try{
            return userDao.exists(number);
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }

    /**
     * get user by number
     *
     * @param number student number
     * @return the user who has the number
     */
    @Override
    @Transactional
    public User getUserByNumber(String number) {
        try{
            return userDao.findOne(number);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * insert the user class
     *
     * @param user the input user
     * @return whether the operation is success or not
     */
    @Override
    @Transactional
    public ResultMessage insertUser(User user) {
        try{
            userDao.save(user);
            return ResultMessage.Success;
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.SystemError;
        }
    }

    /**
     * delete a user
     *
     * @param number student number
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteUser(String number) {
        try{
            userDao.delete(number);
            return ResultMessage.Success;
        }catch (Exception e){
            e.printStackTrace();
            return ResultMessage.SystemError;
        }
    }
}
