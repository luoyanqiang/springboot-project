package cn.food.boot.po;

import java.util.List;

public class UserCustom extends User {

    public List<Orders> getOrders() {
        return ordersList;
    }

    public void setOrders(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    private List<Orders> ordersList;
}
