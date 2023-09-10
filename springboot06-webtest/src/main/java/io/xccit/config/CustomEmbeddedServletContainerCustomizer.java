package io.xccit.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * @author CH_ywx
 * @date 2023-08-04
 * @description 个性化容器定制类 SpringBoot2使用WebServerFactoryCustomizer接口并泛型
 */
public class CustomEmbeddedServletContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8082);
    }
}
