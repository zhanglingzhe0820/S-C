package cn.s_c.entity.food;

import cn.s_c.entity.restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "price")
    private double price;

    @Column(name = "url")
    private String url;

    @Column(name = "maxium")
    private double maxium;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rid")
    private Restaurant restaurant;

    public Food() {
    }

    public Food(String name, String position, double price, String url, double maxium, Restaurant restaurant) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.url = url;
        this.maxium = maxium;
        this.restaurant = restaurant;
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

    public double getMaxium() {
        return maxium;
    }

    public void setMaxium(double maxium) {
        this.maxium = maxium;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
