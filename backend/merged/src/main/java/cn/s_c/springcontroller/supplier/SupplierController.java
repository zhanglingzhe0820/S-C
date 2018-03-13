package cn.s_c.springcontroller.supplier;

import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.supplier.SupplierLoginVo;
import cn.s_c.vo.supplier.SupplierSignUpVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
    @Autowired
    private SupplierBlService supplierBlService;

    @ApiOperation(value = "login", nickname = "login")
    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return supplierBlService.login(new SupplierLoginVo(username, password));
    }

    @ApiOperation(value = "signUp", nickname = "signUp")
    @RequestMapping(method = RequestMethod.GET, path = "/signUp", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage signUp(@RequestParam("name") String name, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("restaurantId") int restaurantId) {
        return supplierBlService.signUp(new SupplierSignUpVo(name, username, password, restaurantId));
    }
}
