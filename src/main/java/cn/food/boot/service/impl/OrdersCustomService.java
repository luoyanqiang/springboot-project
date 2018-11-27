package cn.food.boot.service.impl;

import cn.food.boot.mapper.OrdersCustomMapper;
import cn.food.boot.mapper.OrdersMapper;
import cn.food.boot.mapper.UserCustomMapper;
import cn.food.boot.po.OrdersCustom;
import cn.food.boot.po.UserCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersCustomService implements cn.food.boot.service.OrdersCustom {

    @Autowired
    private OrdersCustomMapper ordersCustomMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<cn.food.boot.po.OrdersCustom> queryOrdersAndUser() {
        List list = ordersCustomMapper.queryOrdersAndUser();
        return list;
    }

    public List<OrdersCustom> queryOrdersAndUserResultMap() {
        List list = ordersCustomMapper.queryOrdersAndUserResultMap();
        return list;
    };
}
