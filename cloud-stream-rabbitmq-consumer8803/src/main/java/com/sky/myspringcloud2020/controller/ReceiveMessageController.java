package com.sky.myspringcloud2020.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getMsg")
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("***2: "+message.getPayload()+" ***port: "+port);
    }
}
