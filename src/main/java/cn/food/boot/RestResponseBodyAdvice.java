package cn.food.boot;

import cn.food.boot.annotation.SerializedField;
import cn.food.boot.utils.Helper;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.*;

@Order(1)
@ControllerAdvice(basePackages = "cn.food.boot.controller")
public class RestResponseBodyAdvice implements ResponseBodyAdvice {
    //包含项
    private String[] includes = {};
    //排除项
    private String[] excludes = {};
    //是否加密
    private boolean encode = false;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //这里可以根据自己的需求
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //重新初始化为默认值
        includes = new String[]{};
        excludes = new String[]{};

        //判断返回的对象是单个对象，还是list，活着是map
        if(o==null){
            return null;
        }

        if(!(o instanceof HashMap)) {
            return o;
        }

        Set keySet = ((HashMap) o).keySet();
        if(!keySet.contains("data")) {
            return o;
        }
        if(methodParameter.getMethod().isAnnotationPresent(SerializedField.class)){
            //获取注解配置的包含和去除字段
            SerializedField serializedField = methodParameter.getMethodAnnotation(SerializedField.class);
            includes = serializedField.includes();
            excludes = serializedField.excludes();
            //是否加密
            encode = serializedField.encode();
        }

        Object data = ((HashMap) o).get("data");
        Object retObj = data;
        if (data instanceof List){
            //List
            List list = (List)data;
            retObj = handleList(list);
        }else if(data instanceof HashMap){
            //Single Object
            retObj = handleSingleMap((Map) data);
        }
        ((HashMap) o).put("data", retObj);
        return o;
    }

    /**
     * 处理返回值是单个enity对象
     *
     * @param map
     * @return
     */
    private Object handleSingleMap(Map map){

        Map<String, Object> newMap = new HashMap<>();
        Set fields = map.keySet();
        for (Object field:fields){
            //如果未配置表示全部的都返回
            if(includes.length==0 && excludes.length==0){
                Object newVal = getNewVal(map.get(field));
                newMap.put((String) field, newVal);
            }else if(includes.length>0){
                //有限考虑包含字段
                if(Helper.isStringInArray((String)field, includes)){
                    Object newVal = getNewVal(map.get(field));
                    newMap.put((String) field, newVal);
                }
            }else{
                //去除字段
                if(excludes.length>0){
                    if(!Helper.isStringInArray((String)field, excludes)){
                        Object newVal = getNewVal(map.get(field));
                        newMap.put((String) field, newVal);
                    }
                }
            }

        }
        return newMap;
    }

    /**
     * 处理返回值是列表
     *
     * @param list
     * @return
     */
    private List handleList(List list){
        List retList = new ArrayList();
        for (Object o:list){
            if(o instanceof Map) {
               o = (Map) handleSingleMap((Map) o);
            }
            retList.add(o);
        }
        return retList;
    }

    /**
     * 获取加密后的新值
     *
     * @param val
     * @return
     */
    private Object getNewVal(Object val){
        Object newVal = "";

        if(val!=null){
            if(encode && (val instanceof String)){
                newVal = Helper.encode(val.toString());
            }else{
                newVal = val;
            }
        }

        return newVal;
    }
}