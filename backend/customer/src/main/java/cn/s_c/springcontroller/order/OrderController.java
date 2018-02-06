package cn.s_c.springcontroller.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderBlService orderBlService;

    @ApiOperation(value = "saveOrder", nickname = "saveOrder")
    @RequestMapping(method = RequestMethod.GET, path = "/saveOrder", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage saveOrder(@RequestBody OrderSaveVo orderSaveVo) {
        return orderBlService.saveOrder(orderSaveVo);
    }

    @ApiOperation(value = "hasUnconfirmedOrder", nickname = "hasUnconfirmedOrder")
    @RequestMapping(method = RequestMethod.GET, path = "/hasUnconfirmedOrder", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = boolean.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public boolean hasUnconfirmedOrder(@RequestBody String wechatId) {
        return orderBlService.hasUnconfirmedOrder(wechatId);
    }

    @ApiOperation(value = "getOrderByUser", nickname = "getOrderByUser")
    @RequestMapping(method = RequestMethod.GET, path = "/getOrderByUser", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = OrderReturnVo[].class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public OrderReturnVo[] getOrderByUser(@RequestBody String wechatId) {
        List<OrderReturnVo> orderReturnVoList=orderBlService.getOrderByUser(wechatId);
        return orderReturnVoList.toArray(new OrderReturnVo[orderReturnVoList.size()]);
    }

    @ApiOperation(value = "deleteOrder", nickname = "deleteOrder")
    @RequestMapping(method = RequestMethod.GET, path = "/deleteOrder", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage deleteOrder(@RequestBody String orderId) {
        return orderBlService.deleteOrder(orderId);
    }

    @ApiOperation(value = "confirmOrder", nickname = "confirmOrder")
    @RequestMapping(method = RequestMethod.GET, path = "/confirmOrder", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ResultMessage.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @ResponseBody
    public ResultMessage confirmOrder(@RequestBody String orderId) {
        return orderBlService.confirmOrder(orderId);
    }
}
