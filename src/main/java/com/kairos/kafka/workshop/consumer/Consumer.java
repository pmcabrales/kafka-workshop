package com.kairos.kafka.workshop.consumer;

import com.kairos.kafka.workshop.model.Item;

import java.util.Map;

public interface Consumer {
    Map<Long, Item> getShoppingItems();
}
