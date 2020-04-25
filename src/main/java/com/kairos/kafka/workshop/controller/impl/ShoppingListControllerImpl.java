package com.kairos.kafka.workshop.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.controller.ShoppingListController;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ShoppingListControllerImpl implements ShoppingListController {

    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public List<Item> getAllItems() {
        return itemService.findAllItems();
    }

    @PutMapping("/{id}")
    public Item toggleItemCheckById(@PathVariable long id) throws JsonProcessingException {
        Optional<Item> item = itemService.findItemById(id);
        if (!item.isPresent()) throw new NoSuchElementException();
        return itemService.toggleItemCheckById(item.get());
    }

    @PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item) throws JsonProcessingException {
        return itemService.save(item);
    }

}
