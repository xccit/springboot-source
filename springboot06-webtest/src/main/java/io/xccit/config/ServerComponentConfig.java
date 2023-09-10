package io.xccit.config;

import io.xccit.filter.HelloFilter;
import io.xccit.listener.HelloContextListener;
import io.xccit.servlet.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * @author CH_ywx
 * @date 2023-08-04
 * @description 容器相关配置
 */
@Configuration
public class ServerComponentConfig {
    @Bean
    public ServletRegistrationBean helloServletServletRegistrationBean(){
        ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>(new HelloServlet(),"/helloServlet");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean helloFilterFilterRegistrationBean(){
        FilterRegistrationBean<HelloFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HelloFilter());
        ArrayList<String> list = new ArrayList<>();
        list.add("/helloServlet");
        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean helloContextListenerServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<HelloContextListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setListener(new HelloContextListener());
        return listenerRegistrationBean;
    }
}
