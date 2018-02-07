package cn.s_c.springcontroller.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserAuthenVo;
import cn.s_c.vo.user.UserConfirmVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserBlService userBlService;

    @ApiOperation(value = "authen", nickname = "authen")
    @RequestMapping(method = RequestMethod.POST, path = "/authen", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage authen(@RequestBody String wechatId, String number) {
        return userBlService.authen(new UserAuthenVo(wechatId, number));
    }

    @ApiOperation(value = "confirmState", nickname = "confirmState")
    @RequestMapping(method = RequestMethod.POST, path = "/confirmState", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = UserConfirmVo.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public UserConfirmVo confirmState(@RequestBody String wechatId) {
        return userBlService.confirmState(wechatId);
    }
}
