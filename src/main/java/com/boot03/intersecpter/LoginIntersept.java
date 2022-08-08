package com.boot03.intersecpter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 刘泰源
 * @version 1.8
 * 登陆检查
 */
// 登陆时进行的拦截操作
public class LoginIntersept implements HandlerInterceptor {
    /**
     * 目标方法执行之前 (所有的登陆检查都要写在PreHandle位置)
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆检查逻辑
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user != null){
            return true; // 即放行
        }
        // 及拦截住了 跳转到登录页
          response.sendRedirect("/"); // 重定向到登录页
          return false; // 即拦截
    }

    /**
     * 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
