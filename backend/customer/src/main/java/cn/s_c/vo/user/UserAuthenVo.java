package cn.s_c.vo.user;

public class UserAuthenVo {
    private String wechatId;
    private String number;

    public UserAuthenVo(String wechatId, String number) {
        this.wechatId = wechatId;
        this.number = number;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
