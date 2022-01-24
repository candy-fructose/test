package com.lingyun.test1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName LoginInterceptorConfig
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/23 19:18
 * @Version
 */
@Configuration
public class LoginInterceptorConfig  implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/*/login");
//    }
}
