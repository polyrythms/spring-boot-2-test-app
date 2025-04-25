package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {
    @Autowired
    private HttpServletRequest requestBean;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("do some interceptor work");
        request.setAttribute("Attr", "newattr");
        return true;
    }
}
