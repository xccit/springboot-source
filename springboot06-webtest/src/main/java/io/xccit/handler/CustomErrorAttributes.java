package io.xccit.handler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author CH_ywx
 * @date 2023-08-03
 * @description
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("company","xccit_dev");
        // ext--->key  0--->request域(参考源码)
        Map<String,Object> ext = (Map<String,Object>)webRequest.getAttribute("ext", 0);//取出request域中的ext(自己的错误消息)
        map.put("ext",ext);
        return map;
    }
}
