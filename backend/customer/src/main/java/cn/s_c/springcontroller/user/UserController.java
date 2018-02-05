package cn.s_c.springcontroller.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserBlService userBlService;

    @ApiOperation(value = "authen", nickname = "authen")
    @RequestMapping(path = "/authen", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage authen(@RequestBody UserVo userVo) {
        return userBlService.register(userVo);
    }
}
