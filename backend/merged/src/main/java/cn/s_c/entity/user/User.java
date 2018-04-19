package cn.s_c.entity.user;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "wechatId")
    private String wechatId;
    @Column(name = "isAuthened")
    @Type(type = "yes_no")
    private boolean isAuthened;
    @Column(name = "isStudent")
    @Type(type = "yes_no")
    private boolean isStudent;
    @Column(name = "number")
    private String number;
    @Column(name = "faithlessTime")
    private int faithlessTime;

    public User() {
    }

    public User(String wechatId, boolean isAuthened, boolean isStudent, String number, int faithlessTime) {
        this.wechatId = wechatId;
        this.isAuthened = isAuthened;
        this.isStudent = isStudent;
        this.number = number;
        this.faithlessTime = faithlessTime;
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

    public int getFaithlessTime() {
        return faithlessTime;
    }

    public void setFaithlessTime(int faithlessTime) {
        this.faithlessTime = faithlessTime;
    }
}
