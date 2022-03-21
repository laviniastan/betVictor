package com.example.kafkarepo.kafkaConfig;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class KafkaConsumer {

    List<String> messageHistory=new ArrayList<>();

    @KafkaListener(topics ="words.processed",groupId = "group_id")
    public void getMessage(String message){
        System.out.println("Consumed message: "+message);
        messageHistory.add(message);
    }
    public List<String> getMessageHistory() {
        return messageHistory;
    }

}
