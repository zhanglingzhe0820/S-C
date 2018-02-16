package cn.s_c.vo.food;

public class FoodPublishVo {

    private String name;
    private String position;
    private double price;
    private String url;
    private double maximum;
    private boolean hasChoice;
    private String[] choice;
    private int restaurantId;

    public FoodPublishVo(String name, String position, double price, String url, double maximum, boolean hasChoice, String[] choice, int restaurantId) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.url = url;
        this.maximum = maximum;
        this.hasChoice = hasChoice;
        this.choice = choice;
        this.restaurantId = restaurantId;
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

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
