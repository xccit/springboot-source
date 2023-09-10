package io.xccit.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-08-08
 * @description Druid配置类
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置访问Druid的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String, Object> initParams = new HashMap<>();
        // 初始化参数去ResourceServlet中找
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin123");
        //以下访问规则都可以自定义
        initParams.put("allow","localhost"); //只允许本地访问,不配置则默认全部都能访问
        initParams.put("deny","192.168.1.9"); //不允许使用本地IP访问
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置访问druid的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        Map<String, Object> initParams = new HashMap<>();
        //初始化参数从WebStatFilter去找
        initParams.put("exclusions","*.css,*.js,/druid/*"); //不会拦截的请求
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }
}
