package com.kairos.kafka.workshop.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.consumer.Consumer;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.producer.Producer;
import com.kairos.kafka.workshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemServiceImpl implements ItemService {

     private AtomicLong lastId = new AtomicLong();

    @Autowired
    private Consumer consumer;

    @Autowired
    private Producer producer;

    public List<Item> findAllItems() {
        Map<Long, Item> map = consumer.getShoppingItems();
        return new ArrayList<>(map.values());
    }

    public Optional<Item> findItemById(long id){
        Map<Long, Item> map = consumer.getShoppingItems();
        return Optional.ofNullable(map.get(id));
    }

    public Item toggleItemCheckById(Item item) throws JsonProcessingException {
        item.setChecked(!item.isChecked());
        producer.send(item.getId(), item);
        return item;
    }

    public Item save(Item item) throws JsonProcessingException {
        item.setId(lastId.incrementAndGet());
        producer.send(item.getId(), item);
        return item;
    }
}
