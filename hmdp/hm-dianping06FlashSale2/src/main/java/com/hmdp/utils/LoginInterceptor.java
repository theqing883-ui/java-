package com.hmdp.utils;

import com.hmdp.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前置处理，检查用户登录状态
* */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("刷新拦截器放行了请求：" + request.getRequestURI());
        UserDTO userDTO = UserHolder.getUser();
        if (userDTO == null) {
            // 未登录，返回 401 状态码
            response.setStatus(401);
            return false;
        }
        //用户已经登录放行
        return true;
    }
}
