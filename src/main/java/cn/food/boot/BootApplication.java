package cn.food.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

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
