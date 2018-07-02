package com.whatsmode.rabbitdomejava.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import com.whatsmode.rabbitdomejava.RabbitDomeJavaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(value=SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitDomeJavaApplication.class)
public class RabbitTest {

    @Autowired
    private Sender sender;

    @Test
    public void sendTest() throws Exception {
         sender.send("0002");
         System.in.read();
    }

    @Autowired
    Channel channel;

    @Test
    public void getOneTest(){

        try {
            String queueName = "0001-queue";
            GetResponse getResponse = channel.basicGet(queueName,false);
            String result = new String(getResponse.getBody());
            System.out.println(result);
            channel.basicAck(getResponse.getEnvelope().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getOneTest2(){

        try {
            String queueName = "0001-queue";
            GetResponse getResponse = channel.basicGet(queueName,false);
            String result = new String(getResponse.getBody());
            System.out.println(result);
           // channel.basicAck(getResponse.getEnvelope().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}