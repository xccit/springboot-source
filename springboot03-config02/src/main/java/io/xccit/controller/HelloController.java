package io.xccit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CH_ywx
 * @date 2023-07-23
 * @description
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
