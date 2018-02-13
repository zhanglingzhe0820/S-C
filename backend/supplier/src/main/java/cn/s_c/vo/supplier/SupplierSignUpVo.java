package cn.s_c.vo.supplier;

import javax.persistence.Column;

public class SupplierSignUpVo {
    private String name;
    private String username;
    private String password;
    private int restaurantId;

    public SupplierSignUpVo(String name, String username, String password, int restaurantId) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
