package com.lingyun.test1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//指定包扫描方法1
//@SpringBootApplication(scanBasePackages = "com.lingyun")
//指定包扫描方法2 需要拆分@SpringBootApplication注解然后自己组合
//@ComponentScan("com.lingyun")
@SpringBootApplication
@MapperScan("com.lingyun.test1.dao")
public class Application {
    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
//        //返回IOC容器
//        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
//        //查看容器中的组件
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println(beanNamesForType.length);
//        for (String name : beanNamesForType) {
//            System.out.println(name);
//        }
//        Myconfig bean = run.getBean(Myconfig.class);
//        bean.user01();
//        Myconfig myconfig1 = bean;
//        bean =  run.getBean(Myconfig.class);
//        System.out.println(bean==myconfig1);
//        System.out.println(run.containsBean("userWithPet"));
//        MyDogConfig bean = run.getBean(MyDogConfig.class);
//        System.out.println(bean);
//        String[] beanNamesForType = run.getBeanNamesForType(com.lingyun.test1.bean.Dog.class);
//        System.out.println("----------");
//        for (String name : beanDefinitionNames){
//            System.out.println(name);
//        }
//        System.out.println("----------");
    }


}
