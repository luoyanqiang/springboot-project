package cn.food.boot.po;

import cn.food.boot.annotation.Mobile;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {
    private Integer id;

    @NotNull(message = "{user.username.isNull}")
    private String username;

    private String sex;

    private Date birthday;

    @NotNull(message = "{user.address.isNull}")
    @Mobile
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}