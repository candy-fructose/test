package com.lingyun.test1.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description : 主题交换机
 **/

@Configuration
public class TopicRabbitConfig {
    //绑定键
    @Value("${topic.man}")
    public String man;
    @Value("${topic.woman}")
    public String woman;
//
//    @Value("${topic.man}")
//    public static void setMan(String man) {
//        TopicRabbitConfig.man = man;
//    }
//
//    @Value("${topic.woman}")
//    public static void setWoman(String woman) {
//        TopicRabbitConfig.woman = woman;
//    }

    @Bean
    public Queue firstQueue() {
        return new Queue(man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(woman);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}