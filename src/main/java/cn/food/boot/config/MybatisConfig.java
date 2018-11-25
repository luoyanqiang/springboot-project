package cn.food.boot.config;

import cn.food.boot.interceptor.MybatisTimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    MybatisTimeInterceptor mybatisTimeInterceptor() {
        return new MybatisTimeInterceptor();
    }

}
