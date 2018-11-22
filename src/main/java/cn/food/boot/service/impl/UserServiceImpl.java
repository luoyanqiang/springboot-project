package cn.food.boot.service.impl;

import cn.food.boot.mapper.UserCustomMapper;
import cn.food.boot.mapper.UserMapper;
import cn.food.boot.po.User;
import cn.food.boot.po.UserQueryVo;
import cn.food.boot.service.UserService;
import cn.food.boot.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserCustomMapper userCustomMapper;


    @Override
    public Map getUsers(Integer curPage, Integer pageSize) {
        curPage = curPage == null ? defaultCurrentPage : curPage;
        pageSize = pageSize == null ? defaultPageSize : pageSize;
        PageHelper.startPage(curPage, pageSize);
        List<cn.food.boot.po.User> list = userMapper.selectByExample(null);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        map.put("list", list);
        map.put("total", total);
        return map;
    }

    @Override
    public List getUserOrders(Integer curPage, Integer pageSize) {
        curPage = curPage == null ? defaultCurrentPage : curPage;
        pageSize = pageSize == null ? defaultPageSize : pageSize;

        UserQueryVo userQueryVo = new UserQueryVo();
        // userQueryVo.setIds("1");

        PageHelper.startPage(curPage, pageSize);
        List list = userCustomMapper.getUserOrders(userQueryVo);
        return list;
    }

    @Override
    public boolean insert(User user) {
        int rs = userMapper.insert(user);
        return rs > 0;
    }

    @Override
    @Async
    public void testAsync() {
        System.out.println("starting========= 2");
        for(int i = 0; i < 6; i++) {
            System.out.println(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("starting========= 2");
    }
}
