package cn.s_c.springcontroller.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class OrderController {
    @Autowired
    private OrderBlService orderBlService;

    @ApiOperation(value = "getOrders", nickname = "getOrders")
    @RequestMapping(method = RequestMethod.POST, path = "/getOrders", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = OrderList[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public OrderList[] getOrders(@RequestParam(name = "supplierUsername") String supplierUsername) {
        return orderBlService.getOrders(supplierUsername);
    }
}
