package cn.s_c.springcontroller.admin;

import cn.s_c.blservice.admin.AdminBlService;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class AdminController {
    @Autowired
    private AdminBlService adminBlService;

    @RequestMapping(method = RequestMethod.GET, path = "/confirmUserFaith", produces = "application/json")
    @ResponseBody
    public ResultMessage confirmFaith() {
        return adminBlService.confirmFaith();
    }
}
