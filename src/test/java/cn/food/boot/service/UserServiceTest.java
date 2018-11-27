package cn.food.boot.service;

import cn.food.boot.mapper.OrdersMapper;
import cn.food.boot.po.User;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void testMapper() {
        List list = ordersMapper.selectByExample(null);
        for(Object o : list) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void testMapper2() {
        Map map = userService.getUsers(1, 10);
        System.out.println(map);
    }

    @Test
    public void getUsersAndOrders() {
        PageHelper.startPage(1, 1);
        List list = userService.getUserOrders(1, 1);
        Assert.assertEquals(1, list.size());
    }

    private static Validator validator;

    @Test
    public void testValidation() {
        User user = new User();
        user.setAddress("sss");
        validator.validate(user);
        // Assert.assertEquals(1,constraintViolations.size());
        // String errorMessage = constraintViolations.iterator().next().getMessage();
        // Assert.assertEquals("这不是有效的电子邮件格式",errorMessage);

        // List<String> validate = validate(user);
        // //这里使用Hibernate的API
        // validate.forEach(row -> {
        //     System.out.println(row.toString());
        // });
    }

    // private static ValidatorFactory factory;
    //
    // static {
    //     factory = Validation.buildDefaultValidatorFactory();
    // }
    //
    // public static <T> List<String> validate(T t) {
    //     Validator validator = factory.getValidator();
    //     Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
    //
    //     List<String> messageList = new ArrayList<>();
    //     for (ConstraintViolation<T> constraintViolation : constraintViolations) {
    //         messageList.add(constraintViolation.getMessage());
    //     }
    //     return messageList;
    // }


}
