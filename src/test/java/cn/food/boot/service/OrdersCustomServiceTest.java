package cn.food.boot.service;

import cn.food.boot.po.OrdersCustom;
import cn.food.boot.service.impl.OrdersCustomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersCustomServiceTest {

    @Autowired
    private OrdersCustomService ordersCustomService;

    @Test
    public void queryOrdersAndUser() {
        List list = ordersCustomService.queryOrdersAndUser();
        for(Object o : list) {
            System.out.println(o.toString());
        }
    }

}
