package com.yo.toolsystem.interceptor;

import com.yo.toolsystem.model.Person;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yoy on 2017/5/8.
 */
public class managesToolsIntercepter implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getSession().getAttribute("person")==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
            return false;
        }else {
            Person person = (Person) httpServletRequest.getSession().getAttribute("person");
            if (person.getCategory()==1){
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
                return false;
            }
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
