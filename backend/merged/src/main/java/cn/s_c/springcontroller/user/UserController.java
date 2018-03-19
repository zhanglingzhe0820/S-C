package cn.s_c.springcontroller.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserAuthenVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserBlService userBlService;

    @RequestMapping(method = RequestMethod.POST, path = "/authen", produces = "application/json")
    @ResponseBody
    public ResultMessage authen(@RequestParam("wechatId") String wechatId, @RequestParam("stNumber") String number) {
        return userBlService.authen(new UserAuthenVo(wechatId, number));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/confirmState", produces = "application/json")
    @ResponseBody
    public UserConfirmVo confirmState(@RequestParam("wechatId") String wechatId) {
        return userBlService.confirmState(wechatId);
    }
}
