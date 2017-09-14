package com.example.czp.interceptor;

import com.example.czp.pojo.User;
import com.example.czp.util.ParamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        User user = (User) request.getSession().getAttribute(ParamUtil.USER); //用户登录拦截
//        if(user == null){
//            return false;
//        }
        
        request.setAttribute(ParamUtil.START_TIME,System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long time = System.currentTimeMillis() - (Long)request.getAttribute(ParamUtil.START_TIME);
        log.info("本次请求的URL是："+request.getRequestURI()+"，响应时间是："+time+"毫秒");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
