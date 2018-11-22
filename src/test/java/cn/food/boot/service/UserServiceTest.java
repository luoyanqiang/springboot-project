package cn.food.boot.service;

import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUsersAndOrders() {
        PageHelper.startPage(1, 1);
        List list = userService.getUserOrders(1, 1);
        Assert.assertEquals(1, list.size());
    }

}
