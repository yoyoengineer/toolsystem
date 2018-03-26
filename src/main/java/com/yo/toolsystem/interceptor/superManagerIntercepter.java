package com.yo.toolsystem.interceptor;

import com.yo.toolsystem.model.Person;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yoy on 2017/5/4.
 */
public class superManagerIntercepter implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.print("url-->"+httpServletRequest.get);
        if (httpServletRequest.getSession().getAttribute("person")==null){
//            httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
            return false;
        }else {
            Person person = (Person) httpServletRequest.getSession().getAttribute("person");
            if (person.getCategory()!=3){
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
