package cn.s_c.entity.order;

import cn.s_c.entity.food.Food;
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

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "foodOrder", joinColumns = @JoinColumn(name = "orderId"))
    @Column(name = "foodList")
    private List<FoodOrder> foodList;

    @Column(name = "commodityTotal")
    private double commodityTotal;

    @Column(name = "serviceTotal")
    private double serviceTotal;

    @Column(name = "isConfirmed")
    @Type(type = "yes_no")
    private boolean isConfirmed;

    public Order() {
    }

    public Order(String wechatId, List<FoodOrder> foodList, double commodityTotal, double serviceTotal, boolean isConfirmed) {
        this.wechatId = wechatId;
        this.foodList = foodList;
        this.commodityTotal = commodityTotal;
        this.serviceTotal = serviceTotal;
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

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
