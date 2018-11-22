package cn.food.boot.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

/**
 * 监听器
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {
        
    }

    public void requestInitialized(ServletRequestEvent sre) {

    }

}
