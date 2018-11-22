package cn.food.boot.config;

import cn.food.boot.core.ret.RetResponse;
import cn.food.boot.utils.Helper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

@Component
public class CustomInterceptor implements HandlerInterceptor {
    @Value("${debug}")
    private boolean debug;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //参数加密校验
        if(debug) {

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();

            Enumeration<String> parameterNamesEnumeration = request.getParameterNames();
            ArrayList<String> parameterNamesList = Collections.list(parameterNamesEnumeration);
            if(!parameterNamesList.contains("timestamp")) {
                out.append(JSONObject.toJSONString(RetResponse.makeErrRsp("参数错误")));
                return false;
            }
            int timestamp = Integer.parseInt(request.getParameter("timestamp"));
            if((Helper.getTimeOfSecond() - timestamp) >  600) {
                out.append(JSONObject.toJSONString(RetResponse.makeErrRsp("接口失效")));
                return false;
            }
            Collections.sort(parameterNamesList);
            // for(Object s : parameterNamesList) {
            //     System.out.println(s);
            // }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
