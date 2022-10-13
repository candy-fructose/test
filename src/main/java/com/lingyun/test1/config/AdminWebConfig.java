//package com.lingyun.test1.config;
//
////import com.lingyun.test1.interceptor.RedisUrlCountInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @ClassName AdminWebConfig
// * @Description TODO
// * @Author LingYun
// * @Date 2022/1/25 17:27
// * @Version
// */
//@Configuration
//public class AdminWebConfig implements WebMvcConfigurer {
//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new LoginInterceptor())
////                .addPathPatterns("/**").excludePathPatterns("/","/static/**","/exception/login");
//        //自己new的话由于不是容器中的组件，拦截器的组件也不会自动注入，所以需要通过容器注入进来
//        registry.addInterceptor(redisUrlCountInterceptor)
//        .addPathPatterns("/**")
//        .excludePathPatterns("/","/static/**","/exception/login");
//    }
//
//
//}
