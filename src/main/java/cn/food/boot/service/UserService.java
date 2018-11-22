package cn.food.boot.service;

import cn.food.boot.po.User;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public interface UserService {

    public Map getUsers(Integer curPage, Integer pageSize);

    public List getUserOrders(Integer curPage, Integer pageSize);

    public boolean insert(User user);

    public void testAsync();
}
