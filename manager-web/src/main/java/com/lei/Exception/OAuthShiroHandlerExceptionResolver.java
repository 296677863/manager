package com.lei.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 12/1/2016.
 */
public class OAuthShiroHandlerExceptionResolver implements HandlerExceptionResolver {
    public OAuthShiroHandlerExceptionResolver() {
    }
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        return null;
    }
}
