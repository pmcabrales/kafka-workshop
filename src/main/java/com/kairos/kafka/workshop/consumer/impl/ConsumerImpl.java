package com.kairos.kafka.workshop.consumer.impl;

import com.kairos.kafka.workshop.consumer.Consumer;
import com.kairos.kafka.workshop.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
