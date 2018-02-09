package cn.s_c.vo.order;

import cn.s_c.entity.food.Food;
import cn.s_c.entity.order.FoodOrder;

import java.util.List;

public class OrderReturnVo {
    private int id;
    private String wechatId;
    private List<FoodOrder> foodList;
    private double commodityTotal;
    private double serviceTotal;
    private int pickHour;
    private int pickMinute;
    private String comment;
    private boolean isConfirmed;

    public OrderReturnVo(int id, String wechatId, List<FoodOrder> foodList, double commodityTotal, double serviceTotal, int pickHour, int pickMinute, String comment, boolean isConfirmed) {
        this.id = id;
        this.wechatId = wechatId;
        this.foodList = foodList;
        this.commodityTotal = commodityTotal;
        this.serviceTotal = serviceTotal;
        this.pickHour = pickHour;
        this.pickMinute = pickMinute;
        this.comment = comment;
        this.isConfirmed = isConfirmed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
