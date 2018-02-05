package cn.s_c.bl.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlServiceImpl implements UserBlService {

    @Autowired
    private UserDataService userDataService;

    /**
     * resgister user
     *
     * @param userVo the user info to be register
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage register(UserVo userVo) {
        return ResultMessage.Success;
    }
}
