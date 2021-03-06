package com.ldg.pajax.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LiuDongguang on 2017/9/6.
 */
public class PajaxReqestFilter extends OncePerRequestFilter {
    private final static String pajaxState="X-PJAX";
    private final static String forwordPath="/pajaxtest/index.jsp?isRedirect=true";
    private String checkPath;

    public static String getPajaxState() {
        return pajaxState;
    }

    public String getCheckPath() {
        return checkPath;
    }

    public void setCheckPath(String checkPath) {
        this.checkPath = checkPath;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        if(SysConstant.pajaxtrue.equals(request.getHeader(pajaxState))){
//            request.getRequestDispatcher(forwordPath).forward(request,response);
//        }else{
//            filterChain.doFilter(request, response);//不执行过滤,继续执行操作
//        }

        filterChain.doFilter(request, response);//不执行过滤,继续执行操作
    }
}
