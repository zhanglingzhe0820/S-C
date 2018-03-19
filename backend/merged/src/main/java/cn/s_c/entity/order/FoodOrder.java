package cn.s_c.entity.order;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FoodOrder implements Serializable {

    private int id;
    private String name;
    private String position;
    private double price;
    private String restaurantName;
    private double num;

    public FoodOrder() {
    }

    public FoodOrder(int id, String name, String position, double price, String restaurantName, double num) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.price = price;
        this.restaurantName = restaurantName;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
