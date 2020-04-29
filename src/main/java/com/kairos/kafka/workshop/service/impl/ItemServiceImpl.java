package com.kairos.kafka.workshop.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.producer.Producer;
import com.kairos.kafka.workshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemServiceImpl implements ItemService {

     private AtomicLong lastId = new AtomicLong();

    @Autowired
    private Producer producer;

    public List<Item> findAllItems() {
        //Return empty array by the moment
        return new ArrayList<>();
    }

    public Optional<Item> findItemById(long id){
        //Return null by the moment
        return Optional.ofNullable(null);
    }

    public Item save(Item item) throws JsonProcessingException {
        item.setId(lastId.incrementAndGet());
        producer.send(item.getId(), item);
        return item;
    }

    public Item increaseItemQuantityById(Item item) throws JsonProcessingException {
        item.setQuantity(item.getQuantity()+1);
        producer.send(item.getId(), item);
        return item;
    }

    public Item decreaseItemQuantityById(Item item) throws JsonProcessingException {
        int quantity = item.getQuantity();
        if(quantity > 0) {
            item.setQuantity(quantity-1);
            producer.send(item.getId(), item);
        }
        return item;
    }

}
