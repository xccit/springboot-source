package io.xccit;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05LoggingApplicationTests {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        // 日志优先级由低到高:trace debug info warn error
        // 作用:可以调整日志输出级别,使用哪个方法输出,日志就只会输出这个级别及更高级别的日志信息
        logger.trace("跟踪信息...");
        logger.debug("调试信息...");
        logger.info("运行信息...");
        logger.warn("警告信息...");
        logger.error("错误信息...");
    }
}
