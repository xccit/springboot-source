package io.xccit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-07-21
 * @description
 */
@RestController
public class HelloController {

    @Value("${user.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello:"+name;
    }
}
