package io.xccit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.xccit.mapper")
public class Springboot09DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09DataMybatisApplication.class, args);
    }

}
