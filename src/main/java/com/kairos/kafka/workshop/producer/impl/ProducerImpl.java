package com.kairos.kafka.workshop.producer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;


@Service
public class ProducerImpl implements Producer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private Properties producerConfiguration;
    private KafkaProducer<String, String> producer;

    @PostConstruct
    public void init() {
        //TODO: Add basic configuration
        producerConfiguration = new Properties();
    }

    @Override
    public void send(long key, Item item) throws JsonProcessingException {
        //TODO: Init the producer

        //Map our item to string
        ObjectMapper objectMapper = new ObjectMapper();
        String stringItem = objectMapper.writeValueAsString(item);

        //TODO: Create a record for producing

        //TODO: Send record
        /*
        System.out.println(item);
        producer.send(producerRecord, (metadata, exception) -> {
            if (exception == null) {
                logger.info("Received new metadata. \n" +
                        "Topic: " + metadata.topic() + "\n" +
                        "Partition: " + metadata.partition() + "\n" +
                        "Offset: " + metadata.offset() + "\n" +
                        "Timestamp: " + metadata.timestamp());
            } else {
                logger.error("Error while producing", exception);
            }
        });
        */

        //TODO: Close the producer

    }

}
