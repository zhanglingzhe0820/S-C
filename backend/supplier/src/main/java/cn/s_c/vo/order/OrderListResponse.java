package cn.s_c.vo.order;

import java.util.List;

public class OrderListResponse {
    private String startTime;
    private String endTime;
    private OrderFood[] foodList;

    public OrderListResponse(String startTime, String endTime, OrderFood[] foodList) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.foodList = foodList;
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

    public OrderFood[] getFoodList() {
        return foodList;
    }

    public void setFoodList(OrderFood[] foodList) {
        this.foodList = foodList;
    }
}
