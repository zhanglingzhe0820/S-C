package cn.s_c.entity.order;

import cn.s_c.entity.food.Food;

import java.io.Serializable;

public class FoodOrder implements Serializable {

    private Food food;
    private double num;

    public FoodOrder(Food food, double num) {
        this.food = food;
        this.num = num;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
