package cn.s_c.vo.order;

import cn.s_c.entity.order.FoodOrder;

import java.util.List;

public class OrderSaveVo {
    private String wechatId;
    private List<FoodOrder> foodList;
    private double commodityTotal;
    private double serviceTotal;
    private int pickHour;
    private int pickMinute;
    private String comment;

    public OrderSaveVo() {
    }

    public OrderSaveVo(String wechatId, List<FoodOrder> foodList, double commodityTotal, double serviceTotal, int pickHour, int pickMinute, String comment) {
        this.wechatId = wechatId;
        this.foodList = foodList;
        this.commodityTotal = commodityTotal;
        this.serviceTotal = serviceTotal;
        this.pickHour = pickHour;
        this.pickMinute = pickMinute;
        this.comment = comment;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public List<FoodOrder> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<FoodOrder> foodList) {
        this.foodList = foodList;
    }

    public double getCommodityTotal() {
        return commodityTotal;
    }

    public void setCommodityTotal(double commodityTotal) {
        this.commodityTotal = commodityTotal;
    }

    public double getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(double serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public int getPickHour() {
        return pickHour;
    }

    public void setPickHour(int pickHour) {
        this.pickHour = pickHour;
    }

    public int getPickMinute() {
        return pickMinute;
    }

    public void setPickMinute(int pickMinute) {
        this.pickMinute = pickMinute;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
