package com.kairos.kafka.workshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ShoppingListControllerIT {

    @Autowired
    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    @MockBean
    private ItemService itemService;

    @Before
    public void initialize() {
        objectMapper = new ObjectMapper();

    }

    @Test
    public void getAllShouldReturn200() throws Exception {
        Item mockItem = new Item("Milk", false);
        List<Item> mockItems = Arrays.asList(mockItem);
        Mockito.when(itemService.findAllItems()).thenReturn(mockItems);
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        List<String> result = objectMapper.readValue(response.getContentAsByteArray(), List.class);

        assertEquals(HttpStatus.OK, HttpStatus.valueOf(response.getStatus()));
        assertFalse(result.isEmpty());
    }

    @Test
    public void toggleItemCheckByIdShouldReturn200AndChangeChecked() throws Exception {
        Item mockItem = new Item("Milk", false);
        Mockito.when(itemService.findItemById(1L)).thenReturn(java.util.Optional.of(mockItem));
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/{id}", "1")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Item result = objectMapper.readValue(response.getContentAsByteArray(), Item.class);

        assertEquals(HttpStatus.OK, HttpStatus.valueOf(response.getStatus()));
        assertEquals(mockItem.getName(), result.getName());
        assertEquals(mockItem.isChecked(), !result.isChecked());
    }

    @Test
    public void toggleItemCheckByIdShouldReturn404() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/{id}", "-1")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND, HttpStatus.valueOf(response.getStatus()));
    }

}
