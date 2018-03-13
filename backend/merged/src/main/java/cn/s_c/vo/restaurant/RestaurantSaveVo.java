package cn.s_c.vo.restaurant;

public class RestaurantSaveVo {
    private String name;
    private String time;

    public RestaurantSaveVo(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
