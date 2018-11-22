package cn.food.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private CustomInterceptor customInterceptor;

    /**
     * 重写请求过处理的方法
     * @return
     */
    // @Override
    // public RequestMappingHandlerMapping requestMappingHandlerMapping() {
    //     // return super.requestMappingHandlerMapping();
    //     RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
    //     handlerMapping.setOrder(0);
    //     return handlerMapping;
    // }

    /**
     * 重写请求过处理的方法
     * @return
     */
    @Override
    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(customInterceptor).addPathPatterns("/**");
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
