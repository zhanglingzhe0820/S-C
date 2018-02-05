package cn.s_c.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "wechatId")
    private String wechatId;
    @Column(name="isAuthened")
    private boolean isAuthened;
    @Column(name="isStudent")
    private boolean isStudent;
    @Column(name = "number")
    private String number;

    public User() {

    }

    public User(String wechatId, boolean isAuthened, boolean isStudent, String number) {
        this.wechatId = wechatId;
        this.isAuthened = isAuthened;
        this.isStudent = isStudent;
        this.number = number;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public boolean isAuthened() {
        return isAuthened;
    }

    public void setAuthened(boolean authened) {
        isAuthened = authened;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
