package com.kairos.kafka.workshop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

	List<Item> findAllItems();

	Optional<Item> findItemById(long id);

	Item toggleItemCheckById(Item item) throws JsonProcessingException;

	Item save(Item item) throws JsonProcessingException;

}
