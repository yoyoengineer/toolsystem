package com.yo.toolsystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yoy on 2017/5/3.
 */
public class signInInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.println("----");
        if (httpServletRequest.getSession().getAttribute("person")==null){
//            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
