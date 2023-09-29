package com.tge.filter;

import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * ClassName: DemoFilter
 * Package: com.tge.filter
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/26 - 23:26
 * Version:
 */

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override // 初始化方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    @Override // 拦截请求后会调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo拦截到了请求。。。。。放行前逻辑");
        // 放行操作
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Demo拦截到了请求.....放行后逻辑");
    }

    @Override // 销毁方法，只调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
