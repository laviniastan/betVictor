package com.example.kafkarepo.controller;


import com.example.kafkarepo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/betvictor")
public class KafkaConsumerController {

    @Autowired
    Service service;

    @GetMapping("/history")
    public String getMessages(){
        System.out.println("Consumer controller ");
        List<String> response = service.getMessages();
        if(response.size()<10)
        return response.toString();
        return response.subList(response.size()-10, response.size()).toString();
    }
}
