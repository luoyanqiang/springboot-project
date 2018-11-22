package cn.food.boot.controller;

import cn.food.boot.annotation.ApiVersion;
import cn.food.boot.core.ret.RetResponse;
import cn.food.boot.core.ret.RetResult;
import cn.food.boot.service.OrdersCustom;
import cn.food.boot.service.UserService;
import cn.food.boot.service.impl.OrdersCustomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "订单接口")
@ApiVersion(1)
@RestController
@RequestMapping("{version}/orders")
public class OrdersController extends BaseController {

    @Autowired
    private OrdersCustomService ordersCustomService;

    @ApiOperation("订单列表")
    @RequestMapping("list")
    public RetResult<List> list() {
        List list = ordersCustomService.queryOrdersAndUser();
        return RetResponse.makeRsp(list);
    }

    @ApiOperation("订单列表2")
    @RequestMapping("list2")
    public RetResult<List> list2() {
        List list = ordersCustomService.queryOrdersAndUserResultMap();
        return RetResponse.makeRsp(list);
    }

}
