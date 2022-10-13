package com.lingyun.test1.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Myconfig
 * @Description TODO
 * @Author LingYun
 * @Date 2022/1/24 21:47
 * @Version
 */
//@ConditionalOnBean(name = "mypet")
//@Import({User.class}) //注入对象 对象名为com.lingyun.test1.bean.User全类名
//@ImportResource("classpath:beans.xml")  //导入spring的配置文件
@Configuration(proxyBeanMethods = true)//默认为true，每次都从容器中取，若为false，则每次都新建，不去管容器内有没有
//@EnableConfigurationProperties(Car.class)//1.开启car的属性配置绑定功能2.将car组件自动注册到容器中
//可用于绑定第三方中没有@Component的类，以此来配置其属性
public class Myconfig {
    //    @Bean("myuser")//给容器添加组件，以方法名为组件id，返回类型就是组件类型
//    public User user01(){
//        return new User(38,"myuser");
//    }
//
//    @BeanDruidDataSourceAutoConfigure
//    public Pet getPet(){
//        return new Pet(15,"pet");
//    }
//    @Bean("userWithPet")
//    @ConditionalOnBean(name = "mypet")
//    public User user02(){
//        return new User(38,"userWithPet",getPet());
//    }
    // MybatisPlus分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }
}