package com.passbook.merchants.security;

import com.passbook.merchants.constants.Constants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.TOKEN_STRING);
        if(StringUtils.isEmpty(token)){
            throw new Exception("Header is lack of"+Constants.TOKEN_STRING+"!");
        }
        if(!token.equals(Constants.TOKEN)){
            throw new Exception("Header"+Constants.TOKEN_STRING+"is not correct!");
        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
