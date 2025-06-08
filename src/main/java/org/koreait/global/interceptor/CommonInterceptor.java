package org.koreait.global.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor {

    public void  v (HttpServletRequest request , HttpServletResponse response, ModelAndView modelAndView){
        modelAndView.addAllObjects("isLogin", mem);
    }






}
