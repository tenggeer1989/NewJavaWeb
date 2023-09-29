package com.tge.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * ClassName: AbcFilter
 * Package: com.tge.filter
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/27 - 22:59
 * Version:
 */

//@WebFilter(urlPatterns = "/*")
public class XbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc拦截到了请求。。。。放行前逻辑");
        // 放行操作
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Abc拦截到了请求.....放行后逻辑");
    }
}
