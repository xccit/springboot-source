package io.xccit.resolver;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author CH_ywx
 * @date 2023-07-30
 * @description
 */
public class CustomLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //从request中获取区域信息参数
        String language = request.getParameter("language");
        Locale locale = Locale.getDefault(); //默认的区域信息(根据浏览器语言)
        if (!StringUtils.isEmpty(language)){ //参数不为空
            String[] s = language.split("_"); //zh_CN  zh语言  CN国家
            locale = new Locale(s[0],s[1]); //构造区域信息对象
        }
        // 返回
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
