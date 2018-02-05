package cn.s_c.blservice.user;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserVo;
import org.springframework.stereotype.Service;

@Service
public interface UserBlService {
    /**
     * resgister user
     * @param userVo the user info to be register
     * @return whether the operation is success or not
     */
    ResultMessage register(UserVo userVo);
}
