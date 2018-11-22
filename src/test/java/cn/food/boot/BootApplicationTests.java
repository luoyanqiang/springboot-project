package cn.food.boot;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPost() throws IOException {
        String url = "http://localhost:8080/testPost";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");

        Map map = new HashMap<>();
        map.put("name", "lisi");
        map.put("age", 8);
        System.out.println(map.toString());
        StringEntity entity = new StringEntity(JSONObject.toJSONString(map), "UTF-8");
        entity.setContentType("application/json");
        entity.setContentEncoding("UTF-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        System.out.println("==============");
        System.out.println(EntityUtils.toString(httpEntity, "UTF-8"));
        EntityUtils.consume(httpEntity);

        response.close();
        httpClient.close();
    }

    @Test
    public void testPost1() throws IOException {
        String url = "http://localhost:8080/testPost";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nvps = new ArrayList<>();
        Map<String, String> map = new HashMap();
        map.put("name", "lisi");
        map.put("age", "18");
        for(Map.Entry<String, String> entry : map.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        HttpEntity httpEntity = response.getEntity();
        System.out.println(EntityUtils.toString(httpEntity, "UTF-8"));
        EntityUtils.consume(httpEntity);

        response.close();
        httpClient.close();
    }

}
