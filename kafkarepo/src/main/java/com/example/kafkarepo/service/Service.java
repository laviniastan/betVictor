package com.example.kafkarepo.service;

import com.example.kafkarepo.kafkaConfig.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    KafkaConsumer kafkaConsumer;

    public List<String> getMessages(){
        System.out.println(kafkaConsumer.getMessageHistory().toString());
        return kafkaConsumer.getMessageHistory();
    }
}
