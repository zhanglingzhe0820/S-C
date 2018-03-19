package cn.s_c.entity.order;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bill")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "wechatId")
    private String wechatId;

    @ElementCollection(fetch = FetchType.LAZY,
            targetClass = FoodOrder.class)
    @CollectionTable(name = "foodOrder")
    @OrderColumn(name = "foodOrderId")
    private List<FoodOrder> foodList;

    @Column(name = "commodityTotal")
    private double commodityTotal;

    @Column(name = "serviceTotal")
    private double serviceTotal;

    @Column(name = "pickHour")
    private int pickHour;

    @Column(name = "pickMinute")
    private int pickMinute;

    @Column(name = "comment")
    private String comment;

    @Column(name = "isConfirmed")
    @Type(type = "yes_no")
    private boolean isConfirmed;

    public Order() {
    }

    public Order(String wechatId, List<FoodOrder> foodList, double commodityTotal, double serviceTotal, int pickHour, int pickMinute, String comment, boolean isConfirmed) {
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
