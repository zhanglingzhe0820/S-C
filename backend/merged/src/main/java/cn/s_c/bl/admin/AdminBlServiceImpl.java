package cn.s_c.bl.admin;

import cn.s_c.blservice.admin.AdminBlService;
import cn.s_c.dataservice.order.OrderDataService;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.entity.order.Order;
import cn.s_c.entity.user.User;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AdminBlServiceImpl implements AdminBlService {
    private final UserDataService userDataService;
    private final OrderDataService orderDataService;

    @Autowired
    public AdminBlServiceImpl(UserDataService userDataService, OrderDataService orderDataService) {
        this.userDataService = userDataService;
        this.orderDataService = orderDataService;
    }

    /**
     * confirm the users' faith
     *
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage confirmFaith() {
        List<Order> orderList = orderDataService.getUnconfirmedOrders();
        for (Order order : orderList) {
            if ((order.getPickHour() * 60 + order.getPickMinute()) < (new Date().getHours() * 60 + new Date().getMinutes())) {
                User user = userDataService.getUserByWechatId(order.getWechatId());
                user.setFaithlessTime(user.getFaithlessTime() + 1);
                orderDataService.deleteOrder(order.getId());
            }
        }
        return ResultMessage.Success;
    }
}
