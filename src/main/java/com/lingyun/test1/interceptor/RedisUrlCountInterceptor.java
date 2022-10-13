//package com.lingyun.test1.interceptor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @ClassName RedisUrlCountInterceptor
// * @Description TODO
// * @Author LingYun
// * @Date 2022/2/21 21:11
// * @Version
// */
//@Component
//public class RedisUrlCountInterceptor implements HandlerInterceptor {
//    @Autowired
//    StringRedisTemplate redisTemplate;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        //默认每次访问当前url就计数加一
//        redisTemplate.opsForValue().increment(requestURI);
////        redisTemplate.opsForValue().
//        return true;
//    }
//}
