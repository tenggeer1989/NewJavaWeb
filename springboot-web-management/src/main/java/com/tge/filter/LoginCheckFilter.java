package com.tge.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tge.pojo.Result;
import com.tge.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: LoginCheckFilter
 * Package: com.tge.filter
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/27 - 23:27
 * Version:
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 1. 获取url
        String url = req.getRequestURL().toString();
        log.info("请求的url:{}",url);

        // 2. 判断url中是否包含login，如果包含，说明是登录操作，放行
         if (url.contains("login")){
             log.info("登录操作，放行...");
             filterChain.doFilter(servletRequest,servletResponse);
             return;
         }

         // 3. 获取请求头中的令牌
        String jwt = req.getHeader("token");

         // 4. 判断令牌是否存在，如果不存在，返回错误结果
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 ，对象转换为json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5. 解析token，如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 ，对象转换为json
            String notLogin = JSONObject.toJSONString(error);
            servletResponse.getWriter().write(notLogin);
            return;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
