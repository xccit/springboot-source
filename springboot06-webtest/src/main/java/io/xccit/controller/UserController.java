package io.xccit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-07-31
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param map model
     * @param session session
     * @return 页面
     */
    @PostMapping("/login")
    public String userLogin(String username, String password, Map<String,Object> map, HttpSession session){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.info(username);
        logger.info(password);
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            //防止表单重复提交,重定向到 /dashboard请求,请求映射配置在配置类中
            return "redirect:/dashboard";
        }else{
            map.put("message","请检查登录信息");
            return "index";
        }
    }
}
