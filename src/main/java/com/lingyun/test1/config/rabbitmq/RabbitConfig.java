package com.lingyun.test1.config.rabbitmq;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description : 生产者推送消息的消息确认调用回调函数
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        //①消息推送到server，但是在server里找不到交换机
        //②消息推送到server，找到交换机了，但是没找到队列
        //③消息推送到sever，交换机和队列啥都没找到
        //④消息推送成功
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("ConfirmCallback:     " + "相关数据：" + correlationData);
                System.out.println("ConfirmCallback:     " + "确认情况：" + ack);
                System.out.println("ConfirmCallback:     " + "原因：" + cause);
            }
        });
        //①消息推送到server，找到交换机了，但是没找到队列
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("ReturnCallback:     " + "消息：" + returnedMessage.getMessage());
                System.out.println("ReturnCallback:     " + "回应码：" + returnedMessage.getReplyCode());
                System.out.println("ReturnCallback:     " + "回应信息：" + returnedMessage.getReplyText());
                System.out.println("ReturnCallback:     " + "交换机：" + returnedMessage.getExchange());
                System.out.println("ReturnCallback:     " + "路由键：" + returnedMessage.getRoutingKey());
            }
        });

        return rabbitTemplate;
    }

}