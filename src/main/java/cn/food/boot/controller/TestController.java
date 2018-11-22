package cn.food.boot.controller;

import cn.food.boot.annotation.ApiVersion;
import cn.food.boot.core.ret.RetResponse;
import cn.food.boot.core.ret.RetResult;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(hidden = true)
@ApiVersion(1)
@RestController
@RequestMapping("{version}/test")
public class TestController extends BaseController{

    @RequestMapping("home")
    public RetResult<String> home() {
        String name = "lisi";
        return RetResponse.makeRsp(name);
    }

}
