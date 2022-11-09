package com.golfzonaca.exception.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.UUID.randomUUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    public static final String Log_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = randomUUID().toString();
        request.setAttribute(Log_ID, uuid);

        //@RequestMapping : HandlerMethod
        //정적 리소스 : ResourceHttpRequestHandler

        log.info("REQUEST  [{}][{}][{}][{}]", uuid, request.getDispatcherType(), requestURI, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        Object uuid = request.getAttribute(Log_ID);
        log.info("RESPONSE [{}][{}][{}]", uuid, requestURI, handler);
        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}

