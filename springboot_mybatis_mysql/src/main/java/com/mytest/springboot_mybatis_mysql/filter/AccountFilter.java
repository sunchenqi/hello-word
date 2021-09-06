package com.mytest.springboot_mybatis_mysql.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {
    private String[] IGNORE_URI = {"/index","/css/","/images/","/js/","/account/login","/account/validataAccount"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--------------------accountFilter-----init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //先查看URI是否在IGNORE_URI里
        String requestURI = request.getRequestURI();
        System.out.println("requestURI====="+requestURI);
         boolean ignore = canPassIgnore(requestURI);
         if(ignore){
             //如果在放行
             chain.doFilter(request,response);
             return;
         }
        Object attribute = request.getSession().getAttribute("account");
        System.out.println("attribute"+attribute);
         if(null == attribute){
             response.sendRedirect("/account/login");
             return;
         }
        chain.doFilter(request,response);
    }

    private boolean canPassIgnore(String requestURI) {
        for (String s : IGNORE_URI) {
            if(requestURI.startsWith(s)){
                return true;
            }
        }
        return false;
    }
}
