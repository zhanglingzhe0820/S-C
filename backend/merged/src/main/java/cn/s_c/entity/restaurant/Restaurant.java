package cn.s_c.entity.restaurant;

import cn.s_c.entity.food.Food;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private String time;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Food> foods;

    public Restaurant() {
    }

    public Restaurant(String name, String time, Set<Food> foods) {
        this.name = name;
        this.time = time;
        this.foods = foods;
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

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
