package com.whatsmode.rabbitdomejava.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Sender {

    @Autowired
    Channel channel;

    public void send(String orderId){

        try {
            long t1 = System.currentTimeMillis();
            String queueName = orderId+"-queue";

            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, RabbitConfig.sendDirectExChange, orderId);
            for (int i = 0; i < 200000; i++) {
                channel.basicPublish(RabbitConfig.sendDirectExChange, orderId, null, String.valueOf(i).getBytes());
            }
            long t2 = System.currentTimeMillis();
            System.out.println("耗时:"+ String.valueOf(t2-t1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
