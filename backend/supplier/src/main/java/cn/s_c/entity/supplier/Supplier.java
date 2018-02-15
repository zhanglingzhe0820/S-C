package cn.s_c.entity.supplier;

import cn.s_c.entity.food.SupplierFood;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SupplierFood> supplierFoodSet;

    public Supplier() {
    }

    public Supplier(String name, String username, String password, int restaurantId, Set<SupplierFood> supplierFoodSet) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.restaurantId = restaurantId;
        this.supplierFoodSet = supplierFoodSet;
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

    public Set<SupplierFood> getSupplierFoodSet() {
        return supplierFoodSet;
    }

    public void setSupplierFoodSet(Set<SupplierFood> supplierFoodSet) {
        this.supplierFoodSet = supplierFoodSet;
    }
}
