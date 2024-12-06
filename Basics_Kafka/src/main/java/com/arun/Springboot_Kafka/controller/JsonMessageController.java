package com.arun.Springboot_Kafka.controller;

import com.arun.Springboot_Kafka.kafka.JsonKafkaProducer;
import com.arun.Springboot_Kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka")
public class JsonMessageController {

    private static final Logger logger= LoggerFactory.getLogger(JsonMessageController.class);
    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        logger.info(String.format("#### -> Producing message -> %s", user));
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message published successfully");
    }
}
