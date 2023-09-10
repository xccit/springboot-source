package io.xccit.handler;

import io.xccit.exceptions.UserNotExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-08-03
 * @description
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotExistsException.class)
    public String userNotExists(Exception e, HttpServletRequest request){
        request.setAttribute("javax.servlet.error.status_code",505); //传入自定义状态码给request域,key是固定的,参阅DefaultErrorAttributes.java
        Map<String,Object> map = new HashMap<>();
        map.put("code","user_not_exists");
        map.put("message",e.getMessage());
        //将我们自己的错误消息塞进request
        request.setAttribute("ext",map);
        //转发到/error请求,实现自适应返回html或json(/error由BasicErrorController.java处理)
        return "forward:/error";
    }
}
