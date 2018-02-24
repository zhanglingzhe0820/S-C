package cn.s_c.entity.food;

import cn.s_c.entity.restaurant.Restaurant;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "maximum")
    private double maximum;

    @Column(name = "hasChoice")
    @Type(type = "yes_no")
    private boolean hasChoice;

    @Column(name = "choice")
    private String[] choice;

    @Column(name = "endHour")
    private int endHour;

    @Column(name = "endMinute")
    private int endMinute;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Food() {
    }

    public Food(String name, String position, double price, String url, double maximum, boolean hasChoice, String[] choice, int endHour, int endMinute, Restaurant restaurant) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.url = url;
        this.maximum = maximum;
        this.hasChoice = hasChoice;
        this.choice = choice;
        this.endHour = endHour;
        this.endMinute = endMinute;
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

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
