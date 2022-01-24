package com.lingyun.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args)  {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        //查看容器中的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
//        MyDogConfig bean = run.getBean(MyDogConfig.class);
//        System.out.println(bean);
        String[] beanNamesForType = run.getBeanNamesForType(com.lingyun.test1.bean.Dog.class);
        System.out.println("----------");
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println("----------");
    }


}
