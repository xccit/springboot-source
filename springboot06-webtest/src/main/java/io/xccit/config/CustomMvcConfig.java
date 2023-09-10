package io.xccit.config;

import io.xccit.handler.LoginHandlerInterceptor;
import io.xccit.resolver.CustomLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author CH_ywx
 * @date 2023-07-29
 * @description
 */
//@EnableWebMvc
//@Configuration
//public class CustomMvcConfig extends DelegatingWebMvcConfiguration {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // /h请求映射到hello.html
//        registry.addViewController("/h").setViewName("hello");
//    }
//}
@Configuration
public class CustomMvcConfig implements WebMvcConfigurer {

    /**
     * 国际化
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        CustomLocaleResolver customLocaleResolver = new CustomLocaleResolver();
        return customLocaleResolver;
    }
    /**
     * 视图控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/dashboard").setViewName("dashboard");
    }

    /**
     * 个性化容器定制
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new CustomEmbeddedServletContainerCustomizer();
    }

    /**
     * 拦截器
     * @param registry
     */
/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns("/login","/","/index.html","/user/login","/webjars/**","/asserts/**"); //放行的请求
    }*/
}
