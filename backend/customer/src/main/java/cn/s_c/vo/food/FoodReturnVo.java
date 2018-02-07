package cn.s_c.vo.food;

import cn.s_c.entity.restaurant.Restaurant;

public class FoodReturnVo {
    private int id;
    private String name;
    private String position;
    private double price;
    private String url;
    private double maximum;
    private Restaurant restaurant;
    private double currentOrders;

    public FoodReturnVo(int id, String name, String position, double price, String url, double maximum, Restaurant restaurant, double currentOrders) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.price = price;
        this.url = url;
        this.maximum = maximum;
        this.restaurant = restaurant;
        this.currentOrders = currentOrders;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(double currentOrders) {
        this.currentOrders = currentOrders;
    }
}
