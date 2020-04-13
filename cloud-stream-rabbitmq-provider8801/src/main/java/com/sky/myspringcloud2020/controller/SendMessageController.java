package com.sky.myspringcloud2020.controller;

import com.sky.myspringcloud2020.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private MessageProviderImpl messageProvider;

    @GetMapping("/sendMsg")
    public String sendMessage(){
        return messageProvider.sender();
    }
}
