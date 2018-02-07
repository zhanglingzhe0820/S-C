package cn.s_c.vo.order;

import cn.s_c.entity.food.Food;
import cn.s_c.entity.order.FoodOrder;

import java.util.List;

public class OrderSaveVo {
    private String wechatId;
    private List<FoodOrder> foodList;
    private double commodityTotal;
    private double serviceTotal;

    public OrderSaveVo(String wechatId, List<FoodOrder> foodList, double commodityTotal, double serviceTotal) {
        this.wechatId = wechatId;
        this.foodList = foodList;
        this.commodityTotal = commodityTotal;
        this.serviceTotal = serviceTotal;
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
}
