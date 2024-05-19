package com.userApplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class kafkaConsumerConfig {

    Logger logger = LoggerFactory.getLogger(kafkaConsumerConfig.class);
    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String location){
        logger.info("Location Received by User: {}", location);
    }
}
