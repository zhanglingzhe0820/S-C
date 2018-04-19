package cn.s_c.springcontroller.order;

import cn.s_c.blservice.order.OrderBlService;
import cn.s_c.exception.UserDoesNotFaithException;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.order.OrderListResponse;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderBlService orderBlService;

    @RequestMapping(method = RequestMethod.POST, path = "/saveOrder", produces = "application/json")
    @ResponseBody
    public ResultMessage saveOrder(@RequestBody OrderSaveVo orderSaveVo) {
        try {
            return orderBlService.saveOrder(orderSaveVo);
        } catch (UserDoesNotFaithException e) {
            e.printStackTrace();
            return ResultMessage.UserError;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/hasUnconfirmedOrder", produces = "application/json")
    @ResponseBody
    public boolean hasUnconfirmedOrder(@RequestParam("wechatId") String wechatId) {
        return orderBlService.hasUnconfirmedOrder(wechatId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getOrderByUser", produces = "application/json")
    @ResponseBody
    public OrderReturnVo[] getOrderByUser(@RequestParam("wechatId") String wechatId) {
        List<OrderReturnVo> orderReturnVoList = orderBlService.getOrderByUser(wechatId);
        return orderReturnVoList.toArray(new OrderReturnVo[orderReturnVoList.size()]);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteOrder", produces = "application/json")
    @ResponseBody
    public ResultMessage deleteOrder(@RequestParam("orderId") int orderId) {
        return orderBlService.deleteOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/confirmOrder", produces = "application/json")
    @ResponseBody
    public ResultMessage confirmOrder(@RequestParam("orderId") int orderId) {
        return orderBlService.confirmOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getOrders", produces = "application/json")
    @ResponseBody
    public OrderListResponse[] getOrders(@RequestParam(name = "supplierUsername") String supplierUsername, @RequestParam(name = "startHour") int startHour, @RequestParam(name = "startMinute") int startMinute, @RequestParam(name = "endHour") int endHour, @RequestParam(name = "endMinute") int endMinute) {
        return Convertor.orderListsToOrderListResponses(orderBlService.getOrders(supplierUsername, startHour, startMinute, endHour, endMinute));
    }
}
