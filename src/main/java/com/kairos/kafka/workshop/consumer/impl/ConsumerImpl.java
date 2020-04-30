package com.kairos.kafka.workshop.consumer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairos.kafka.workshop.consumer.Consumer;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.utils.Topics;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumerImpl implements Consumer {

    private Logger logger = LoggerFactory.getLogger(ConsumerImpl.class.getName());

    private static Map<Long, Item> shoppingItems = new HashMap<>();

    //TODO: Write our consumer. Use @KafkaListeners

    public Map<Long, Item> getShoppingItems() {
        return shoppingItems;
    }

}
