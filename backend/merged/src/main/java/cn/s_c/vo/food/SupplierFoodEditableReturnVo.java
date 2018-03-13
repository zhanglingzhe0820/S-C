package cn.s_c.vo.food;

public class SupplierFoodEditableReturnVo {
    private int id;
    private String name;
    private double price;
    private String url;
    private boolean hasChoice;
    private String[] choice;

    public SupplierFoodEditableReturnVo(int id, String name, double price, String url, boolean hasChoice, String[] choice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.hasChoice = hasChoice;
        this.choice = choice;
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
}
