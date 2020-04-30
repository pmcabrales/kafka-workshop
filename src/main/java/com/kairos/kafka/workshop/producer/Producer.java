package com.kairos.kafka.workshop.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.model.Item;

public interface Producer {
    void send(long key, Item item) throws JsonProcessingException;
}
