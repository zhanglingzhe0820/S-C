package cn.s_c.vo.food;

public class SupplierFoodReturnVo {
    private int id;
    private String name;
    private double price;
    private String url;

    public SupplierFoodReturnVo(int id, String name, double price, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
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
}
