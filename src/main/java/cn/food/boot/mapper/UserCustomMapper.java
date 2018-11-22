package cn.food.boot.mapper;

import cn.food.boot.po.UserQueryVo;

import java.util.List;

public interface UserCustomMapper {

    public List getUserOrders(UserQueryVo userQueryVo);
}
