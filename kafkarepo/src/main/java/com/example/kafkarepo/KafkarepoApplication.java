package com.example.kafkarepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkarepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkarepoApplication.class, args);
    }

}
