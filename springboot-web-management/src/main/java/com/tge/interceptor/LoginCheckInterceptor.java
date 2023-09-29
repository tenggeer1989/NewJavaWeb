package com.tge.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.tge.pojo.Result;
import com.tge.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: LoginCheckInterceptor
 * Package: com.tge.interceptor
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/28 - 20:23
 * Version:
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override// 目标资源方法运行前运行，返回true，放行，返回false，不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的");

        // 2. 判断url中是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("login")){
            log.info("登录操作，放行...");
            return true;
        }

        // 3. 获取请求头中的令牌
        String jwt = request.getHeader("token");

        // 4. 判断令牌是否存在，如果不存在，返回错误结果
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 ，对象转换为json
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
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
            response.getWriter().write(notLogin);
            return false;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override// 目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override// 视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.....");
    }
}
