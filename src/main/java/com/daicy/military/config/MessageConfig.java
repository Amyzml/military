package com.daicy.military.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

//@Configuration
public class MessageConfig {


    public String exchage = "daicy-exchange-sample";

    public String queue = "daicy-queue-sample";


    @Bean(name = "queue")
    public Queue queue(ConnectionFactory connectionFactory) throws IOException {
        //在初始化的时候需要创建，应为spring boot默认第一次使用的时候才初始化rabbitmq交换机队列。
        connectionFactory.createConnection().createChannel(false).queueDeclare(queue, true, false, false, null);
        return new Queue(queue);
    }

    @Bean(name = "exchange")
    public TopicExchange exchange() {
        return new TopicExchange(exchage);
    }


    /**
     * 绑定用户交换机里面routingkey 是 user.user user.group 到 queue
     */


    @Bean(name = "userExchange")
    public TopicExchange userExchange() {
        return new TopicExchange("daicy-exchange-user");
    }

    @Bean
    Binding bindingUserUserExchange(@Qualifier("queue") Queue queue, @Qualifier("userExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("user.user");
    }

    @Bean
    Binding bindingUserGroupExchange(@Qualifier("queue") Queue queue, @Qualifier("userExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("user.group");
    }


}
