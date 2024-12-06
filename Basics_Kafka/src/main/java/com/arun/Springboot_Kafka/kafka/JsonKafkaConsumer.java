package com.arun.Springboot_Kafka.kafka;

import com.arun.Springboot_Kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger= LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kakfa.topic-json.name:default}", groupId = "MyGroup")
    public void consume(User user) {
        logger.info(String.format("#### -> Consumed message -> %s", user.toString()));
    }
}
