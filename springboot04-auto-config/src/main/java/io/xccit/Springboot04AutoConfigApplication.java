package io.xccit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot04AutoConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot04AutoConfigApplication.class, args);
        Logger logger = LoggerFactory.getLogger(Springboot04AutoConfigApplication.class);
        logger.info("Hello World!");
    }
}
