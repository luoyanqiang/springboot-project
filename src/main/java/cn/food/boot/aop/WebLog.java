package cn.food.boot.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@Aspect
@Component
public class WebLog {
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Pointcut("execution(public * cn.food.boot.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url:" + request.getRequestURL().toString());
        logger.info("method:" + request.getMethod());
        Enumeration<String> enumeration = request.getParameterNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            logger.info("name:{}, value:{}", name, request.getParameter(name));
        }

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        logger.info("response:" + ret);
    }




}
