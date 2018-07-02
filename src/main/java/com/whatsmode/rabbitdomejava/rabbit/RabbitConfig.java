package com.whatsmode.rabbitdomejava.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        return factory;
    }

    @Autowired
    ConnectionFactory factory;

    @Bean
    public Connection connection(){
        try {
            Connection conn = factory.newConnection();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Autowired
    Connection connection;

    @Bean
    @Scope()
    public Channel channel(){
        try {
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(sendDirectExChange, "direct", true);
            return channel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    Channel channel;

    public static final String sendDirectExChange="send-directExChange";

//    @InitBinder
//    public void initExchange(){
//        try {
//            channel.exchangeDeclare("directExChange", "direct", true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
