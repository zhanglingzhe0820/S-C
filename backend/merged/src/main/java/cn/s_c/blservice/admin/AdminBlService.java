package cn.s_c.blservice.admin;

import cn.s_c.vo.ResultMessage;

public interface AdminBlService {
    /**
     * confirm the users' faith
     *
     * @return whether the operation is success or not
     */
    ResultMessage confirmFaith();
}
