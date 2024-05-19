package com.deliveryBoyApplication.service;

import com.deliveryBoyApplication.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstants.LOCATION_UPDATE_TOPIC, location);
        logger.info("location produced and sent to consumer");
        return true;
    }
}
