package com.kairos.kafka.workshop.controller.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.producer.Producer;
import com.kairos.kafka.workshop.service.ItemService;
import com.kairos.kafka.workshop.service.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private Producer producer;

    protected Item mockItem;

    @InjectMocks
    private ItemService itemService = new ItemServiceImpl();

    @Test
    public void decreaseItemQuantityByIdShouldDecreaseItemQuantityInOneUnit() throws JsonProcessingException {
        mockItem = new Item("Milk", 2);
        MockitoAnnotations.initMocks(this);

        Item item = itemService.decreaseItemQuantityById(mockItem);

        assertEquals(item.getQuantity(), 1);
    }

    @Test
    public void decreaseItemQuantityByIdShouldNeverResultNegative() throws JsonProcessingException {
        mockItem = new Item("Milk", 0);
        MockitoAnnotations.initMocks(this);

        Item item = itemService.decreaseItemQuantityById(mockItem);

        assertEquals(item.getQuantity(), 0);
    }


    @Test
    public void increaseItemQuantityByIdShouldIncreaseItemQuantityInOneUnit() throws JsonProcessingException {
        mockItem = new Item("Milk", 2);
        MockitoAnnotations.initMocks(this);

        Item item = itemService.increaseItemQuantityById(mockItem);

        assertEquals(item.getQuantity(), 3);
    }

}
