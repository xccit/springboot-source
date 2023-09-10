package io.xccit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author CH_ywx
 * @date 2023-08-05
 * @description
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","Hello JSP!");
        return "hello";
    }
}
