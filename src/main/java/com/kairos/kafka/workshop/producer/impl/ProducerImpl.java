package com.kairos.kafka.workshop.producer.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairos.kafka.workshop.avro.AvroItem;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.producer.Producer;
import com.kairos.kafka.workshop.utils.Topics;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;


@Service
public class ProducerImpl implements Producer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private Properties producerConfiguration;
    private KafkaProducer<String, AvroItem> producer;

    @PostConstruct
    public void init() {
        producerConfiguration = new Properties();
        producerConfiguration.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerConfiguration.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        producerConfiguration.setProperty(ProducerConfig.RETRIES_CONFIG, "10");
        producerConfiguration.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerConfiguration.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        producerConfiguration.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
    }

    @Override
    public void send(long key, Item item) throws JsonProcessingException {
        AvroItem avroItem = transformItemToAvro(item);

        producer = new KafkaProducer<>(producerConfiguration);

        ProducerRecord<String, AvroItem> producerRecord = new ProducerRecord<>(
                Topics.TOPIC_SHOPPING_LIST, String.valueOf(key), avroItem
        );

        System.out.println(avroItem);
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

        producer.flush();
        producer.close();
    }

    private AvroItem transformItemToAvro(Item item) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String entryString = objectMapper.writeValueAsString(item);
        return objectMapper.readValue(entryString, AvroItem.class);
    }

}
