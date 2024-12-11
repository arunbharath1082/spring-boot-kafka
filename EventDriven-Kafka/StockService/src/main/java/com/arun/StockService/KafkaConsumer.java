package com.arun.StockService;

import com.arun.BaseDomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "order-topics",
            groupId = "stock-service")
    public void consumeMessage(OrderEvent event){
        logger.info("Consumed message==@@@@@@@@********%%%%%%%%%%%%%%%%%>"+event.toString());
    }

}
