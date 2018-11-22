package cn.food.boot.mapper;

import cn.food.boot.po.OrdersCustom;

import java.util.List;

public interface OrdersCustomMapper {

    public List<OrdersCustom> queryOrdersAndUser();
    public List<OrdersCustom> queryOrdersAndUserResultMap();

}
