package cn.s_c.springcontroller.supplier;

import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.supplier.SupplierLoginVo;
import cn.s_c.vo.supplier.SupplierSignUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
    @Autowired
    private SupplierBlService supplierBlService;

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = "application/json")
    @ResponseBody
    public ResultMessage login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return supplierBlService.login(new SupplierLoginVo(username, password));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/signUp", produces = "application/json")
    @ResponseBody
    public ResultMessage signUp(@RequestParam("name") String name, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("restaurantId") int restaurantId) {
        return supplierBlService.signUp(new SupplierSignUpVo(name, username, password, restaurantId));
    }
}
