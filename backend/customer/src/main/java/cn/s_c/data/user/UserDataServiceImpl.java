package cn.s_c.data.user;

import cn.s_c.data.dao.user.UserDao;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.entity.user.User;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Resource
    private UserDao userDao;

    /**
     * watch whether the number exists
     *
     * @param number student or teacher number
     * @return the number exists or not
     */
    @Override
    public boolean isNumberExisted(String number) {
        System.out.println(userDao);
        return userDao.findUsersByNumber(number).size()!=0;
    }

    /**
     * bind the wechat id and student or teacher number
     *
     * @param wechatId  wechat id
     * @param number    student or teacher number
     * @param isStudent whether the number is a student id
     * @return the operation is success or not
     */
    @Override
    public ResultMessage bindWechatIdAndNumber(String wechatId, String number, boolean isStudent) {
        User user=new User(wechatId,true,isStudent,number);
        if(userDao.save(user)!=null){
            return ResultMessage.Success;
        }else{
            return ResultMessage.SystemError;
        }
    }

    /**
     * get the user's state by its wechat id
     *
     * @param wechatId wechat id
     * @return the user's state
     */
    @Override
    public UserConfirmVo getUserStateByWechat(String wechatId) {
        User user=userDao.findOne(wechatId);
        if(user==null){
            return new UserConfirmVo(false,false);
        }
        else{
            return new UserConfirmVo(user.isAuthened(),user.isStudent());
        }
    }
}
