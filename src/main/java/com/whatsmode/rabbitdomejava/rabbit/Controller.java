package com.whatsmode.rabbitdomejava.rabbit;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.GetResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//public class Controller {
//    @Autowired
//    Channel channel;
//
//    public ResponseEntity<String> get(@RequestParam("orderId")String orderId){
//        try {
//            GetResponse getResponse = channel.basicGet(orderId,false);
//            String result = new String(getResponse.getBody());
//           // return
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
