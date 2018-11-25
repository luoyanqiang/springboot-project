package cn.food.boot;

import com.github.pagehelper.PageHelper;
import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan(basePackages = "cn.food.boot.mapper")
@ServletComponentScan(basePackages = "cn.food.boot.listener")
@EnableSwagger2
public class BootApplication extends SpringBootServletInitializer {

    // public static void main(String[] args) {
    //     SpringApplication.run(BootApplication.class, args);
    // }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootApplication.class);
    }



}
