package cn.s_c.entity.supplier;

import cn.s_c.entity.food.SupplierFood;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "restaurantId")
    private int restaurantId;


    @ElementCollection(fetch = FetchType.LAZY,
            targetClass = SupplierFood.class)
    @CollectionTable(name = "supplierFood")
    @OrderColumn(name = "supplierFoodId")
    private List<SupplierFood> supplierFoodList;

    public Supplier() {
    }

    public Supplier(String name, String username, String password, int restaurantId, List<SupplierFood> supplierFoodList) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.restaurantId = restaurantId;
        this.supplierFoodList = supplierFoodList;
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

    public List<SupplierFood> getSupplierFoodList() {
        return supplierFoodList;
    }

    public void setSupplierFoodList(List<SupplierFood> supplierFoodList) {
        this.supplierFoodList = supplierFoodList;
    }
}
