package cn.food.boot.controller;

import cn.food.boot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }

    @RequestMapping("index")
    public String index() {
        int b = 10 / 0;
        return "index";
    }

    @RequestMapping("/users")
    public Map getUsers() {
        Map map = userService.getUsers(1,2);
        return map;
    }

    @RequestMapping("testAsync")
    public String testAsync() {
        System.out.println("starting========= 1");
        userService.testAsync();
        System.out.println("starting========= 4");

        return "success";
    }
    
}
