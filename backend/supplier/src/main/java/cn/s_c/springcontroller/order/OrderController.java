package cn.s_c.springcontroller.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderList;
import cn.s_c.vo.order.OrderListResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderBlService orderBlService;

    @ApiOperation(value = "getOrders", nickname = "getOrders")
    @RequestMapping(method = RequestMethod.POST, path = "/getOrders", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = OrderListResponse[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public OrderListResponse[] getOrders(@RequestParam(name = "supplierUsername") String supplierUsername, @RequestParam(name = "startHour") int startHour, @RequestParam(name = "startMinute") int startMinute, @RequestParam(name = "endHour") int endHour, @RequestParam(name = "endMinute") int endMinute) {
        return Convertor.orderListsToOrderListResponses(orderBlService.getOrders(supplierUsername, startHour, startMinute, endHour, endMinute));
    }
}
