package cn.food.boot.controller;

import cn.food.boot.annotation.ApiVersion;
import cn.food.boot.annotation.SerializedField;
import cn.food.boot.core.ret.RetCode;
import cn.food.boot.core.ret.RetResponse;
import cn.food.boot.core.ret.RetResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiVersion(100)
@Api(value = "/index", tags = "首页相关api")
@RestController
@RequestMapping("{version}")
public class IndexController extends BaseController {

    @Value("${test-name}")
    private String testName;

    @ApiOperation("测试配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码"),
    })
    @RequestMapping("/testConfigParam")
    public String testConfigParam() {
        return testName;
    }

    @PostMapping("/testPost")
    public RetResult<Map> testPost(HttpServletRequest httpServletRequest) {
        // Map map = request.getParameterMap();
        // Enumeration enumeration = request.getParameterNames();
        // Map map = new HashMap();
        // JSONObject jsonParam = this.getJSONParam(httpServletRequest);
        Map map = this.getRequestMap();
        // String str = jsonParam.toJSONString();
        System.out.println(map);
        // while (enumeration.hasMoreElements()) {
        //     String key = (String) enumeration.nextElement();
        //     System.out.println(key);
        //     Object value = request.getParameter(key);
        //     System.out.println(value);
        //     map.put(key, value);
        // }
        // System.out.println(map);
        // Set set = map.keySet();
        // for(Object s : set) {
        //     System.out.println(s);
        //     System.out.println(map.get(s));
        // }
        return RetResponse.makeRsp(map);
    }

    @PostMapping("testPostJson")
    @SerializedField(excludes = {"name"})
    public RetResult<JSONObject> testPostJson(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam.toJSONString());
        return RetResponse.makeRsp(jsonParam);
    }

    // public JSONObject getJSONParam(HttpServletRequest request){
    //     JSONObject jsonParam = null;
    //     try {
    //         // 获取输入流
    //         BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
    //
    //         // 写入数据到Stringbuilder
    //         StringBuilder sb = new StringBuilder();
    //         String line = null;
    //         while ((line = streamReader.readLine()) != null) {
    //             sb.append(line);
    //         }
    //         jsonParam = JSONObject.parseObject(sb.toString());
    //         // 直接将json信息打印出来
    //         System.out.println(jsonParam.toJSONString());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return jsonParam;
    // }

    @PostMapping("/testList")
    @SerializedField(excludes = {"name"}, encode = true)
    public RetResult<List> testPostList() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("name", "lisi");
        map.put("age", "18");
        list.add(map);
        list.add(this.getRequestMap());
        return RetResponse.makeRsp(list);
    }

}
