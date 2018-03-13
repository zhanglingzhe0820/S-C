package cn.s_c.vo.order;

import java.util.List;

public class OrderList {
    private String startTime;
    private String endTime;
    private List<OrderFood> orderFoodList;

    public OrderList(String startTime, String endTime, List<OrderFood> orderFoodList) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.orderFoodList = orderFoodList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<OrderFood> getOrderFoodList() {
        return orderFoodList;
    }

    public void setOrderFoodList(List<OrderFood> orderFoodList) {
        this.orderFoodList = orderFoodList;
    }
}
