package com.flower.config;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import com.flower.reponse.Result;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author 淮南
 * 自定义拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {

    private final List<String> IGNORE_PATHS = Arrays.asList("/login","/register","");

    /**
     * 每次请求之前做拦截
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return 返回是否拦截
     * @throws Exception 异常
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求路径
        String requestUri = request.getRequestURI();
        //判断是否在忽略的路径中
        if (IGNORE_PATHS.stream().anyMatch(requestUri::contains)) {
            return true;
        }
        //获取认证头
        String auth = request.getHeader("Authentication");
        //验证认证头
        if (StrUtil.isBlank(auth)) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(Result.AUTH_FAIL.str());
            return false;
        }
        return true;
    }

}
