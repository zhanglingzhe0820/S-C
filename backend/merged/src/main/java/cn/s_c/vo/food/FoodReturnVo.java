package cn.s_c.vo.food;

import cn.s_c.vo.restaurant.RestaurantReturnVo;

public class FoodReturnVo {
    private int id;
    private String name;
    private String position;
    private double price;
    private String url;
    private double maximum;
    private boolean hasChoice;
    private String[] choice;
    private RestaurantReturnVo restaurantReturnVo;
    private double currentOrders;

    public FoodReturnVo(int id, String name, String position, double price, String url, double maximum, boolean hasChoice, String[] choice, RestaurantReturnVo restaurantReturnVo, double currentOrders) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.price = price;
        this.url = url;
        this.maximum = maximum;
        this.hasChoice = hasChoice;
        this.choice = choice;
        this.restaurantReturnVo = restaurantReturnVo;
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

    public boolean isHasChoice() {
        return hasChoice;
    }

    public void setHasChoice(boolean hasChoice) {
        this.hasChoice = hasChoice;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public RestaurantReturnVo getRestaurantReturnVo() {
        return restaurantReturnVo;
    }

    public void setRestaurantReturnVo(RestaurantReturnVo restaurantReturnVo) {
        this.restaurantReturnVo = restaurantReturnVo;
    }

    public double getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(double currentOrders) {
        this.currentOrders = currentOrders;
    }
}
