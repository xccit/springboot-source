package io.xccit.controller;

import io.xccit.exceptions.UserNotExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-07-28
 * @description 测试Thymeleaf
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("lastName","Xccit");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        map.put("str","<h1>Hello</h1>");
        return "hello";
    }
    @RequestMapping("/customError")
    @ResponseBody
    public String customError(String username){
        if (username.equals("aaa")){
            throw new UserNotExistsException("用户不存在");
        }
        return "hello";
    }
}
