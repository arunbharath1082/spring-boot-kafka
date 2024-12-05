package com.arun.Springboot_Kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    public static final String TOPIC_NAME = "arun_topic";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC_NAME)
                .build();
    }
}
