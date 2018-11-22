package cn.food.boot.po;

import com.github.pagehelper.PageHelper;

import java.util.List;

public class UserQueryVo {

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    private String ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    private User user;
    private UserCustom userCustom;

}
