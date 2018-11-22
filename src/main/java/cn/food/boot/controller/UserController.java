package cn.food.boot.controller;

import cn.food.boot.annotation.ApiVersion;
import cn.food.boot.core.ret.RetCode;
import cn.food.boot.core.ret.RetResponse;
import cn.food.boot.core.ret.RetResult;
import cn.food.boot.po.User;
import cn.food.boot.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(tags = "用户接口")
@ApiVersion(1)
@RestController
@RequestMapping("{version}/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户列表")
    @RequestMapping("list")
    public RetResult<List> list(Integer curPage, Integer pageSize) {
        List list = userService.getUserOrders(curPage, pageSize);
        // Map map = userService.getUsers(curPage, pageSize);
        return RetResponse.makeRsp(list);
    }

    @ApiOperation("添加用户")
    @RequestMapping("add")
    public RetResult<String> add(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return RetResponse.makeErrRsp(RetCode.PARAM_ERROR, result.getFieldError().getDefaultMessage());
        }
        if(user.getUsername() == null) {
            return RetResponse.makeRsp("参数错误");
        }
        boolean rs = userService.insert(user);
        if(rs) {
            return RetResponse.makeRsp("success");
        } else {
            return RetResponse.makeRsp("fail");
        }
    }

    @ApiOperation("用户列表")
    @RequestMapping("queryUsers")
    public RetResult<Map> queryUsers(Integer curPage, Integer pageSize) {
        Map map = userService.getUsers(1, 20);
        return RetResponse.makeRsp(map);
    }

}
