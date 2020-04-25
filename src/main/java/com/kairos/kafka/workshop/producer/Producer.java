package com.kairos.kafka.workshop.producer;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Producer {
    void send(long key, Object object) throws JsonProcessingException;
}
