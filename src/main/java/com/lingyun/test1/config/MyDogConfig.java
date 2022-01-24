package com.lingyun.test1.config;

import com.lingyun.test1.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyDogConfig
 * @Description TODO
 * @Author LingYun
 * @Date 2021/4/8 21:04
 * @Version
 */

@Configuration(proxyBeanMethods = true)
    public class MyDogConfig {
   //方法或类
    @ConditionalOnBean(Dog.class)
    //组件名默认为方法名，也可自定义，注册的组件默认就是单实例的
    @Bean("myDog")
    public Dog dog01(){
        return new Dog("dog1",5);
    }
    @Bean
    public Dog dog02(){
        return new Dog("dog2",25);
    }

}
