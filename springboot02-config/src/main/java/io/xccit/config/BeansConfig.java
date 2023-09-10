package io.xccit.config;

import io.xccit.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CH_ywx
 * @date 2023-07-22
 * @description
 */
@Configuration
public class BeansConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
