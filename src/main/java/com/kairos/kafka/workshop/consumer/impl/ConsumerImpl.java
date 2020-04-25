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

    @KafkaListener(topics = Topics.TOPIC_BD_SHOPPING_LIST, groupId = "kafka-workshop")
    public void receive(ConsumerRecord<String, String> record){
        logger.info("Consumer is processing record with Key: " + record.key() + ", Value: " + record.value());

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Item receivedItem = objectMapper.readValue(record.value(), Item.class);
            shoppingItems.put(receivedItem.getId(), receivedItem);
        } catch (JsonProcessingException e) {
            logger.error("Error while mapping entry: " + record.value(), e);
        }
    }

    public Map<Long, Item> getShoppingItems() {
        return shoppingItems;
    }

}
