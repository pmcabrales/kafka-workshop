package com.kairos.kafka.workshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kairos.kafka.workshop.model.Item;
import com.kairos.kafka.workshop.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
    protected Item mockItem;

    @MockBean
    private ItemService itemService;

    @Before
    public void initialize() {
        objectMapper = new ObjectMapper();
        mockItem = new Item("Milk", 1);
        mockItem.setId(1);
    }

    @Test
    public void getAllShouldReturn200() throws Exception {
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
    public void createItemShouldReturn201() throws Exception {
        Mockito.when(itemService.save(Mockito.any())).thenReturn(mockItem);
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/")
                .content(objectMapper.writeValueAsString(mockItem))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        Item result = objectMapper.readValue(response.getContentAsByteArray(), Item.class);

        assertEquals(HttpStatus.CREATED, HttpStatus.valueOf(response.getStatus()));
        assertEquals(mockItem.getName(), result.getName());
        assertEquals(mockItem.getQuantity(), result.getQuantity());
    }

    @Test
    public void decreaseItemByIdShouldReturn200() throws Exception {
        Mockito.when(itemService.findItemById(1)).thenReturn(java.util.Optional.of(mockItem));
        Mockito.when(itemService.decreaseItemQuantityById(Mockito.any())).thenReturn(mockItem);
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put("/less/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Item result = objectMapper.readValue(response.getContentAsByteArray(), Item.class);

        assertEquals(HttpStatus.OK, HttpStatus.valueOf(response.getStatus()));
        assertEquals(mockItem.getName(), result.getName());
        assertEquals(mockItem.getQuantity(), result.getQuantity());
    }

    @Test
    public void increaseItemByIdShouldReturn200() throws Exception {
        Mockito.when(itemService.findItemById(1)).thenReturn(java.util.Optional.of(mockItem));
        Mockito.when(itemService.increaseItemQuantityById(Mockito.any())).thenReturn(mockItem);
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put("/more/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Item result = objectMapper.readValue(response.getContentAsByteArray(), Item.class);

        assertEquals(HttpStatus.OK, HttpStatus.valueOf(response.getStatus()));
        assertEquals(mockItem.getName(), result.getName());
        assertEquals(mockItem.getQuantity(), result.getQuantity());
    }

    @Test
    public void decreaseItemByIdShouldReturn404() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put("/less/{id}", -1)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND, HttpStatus.valueOf(response.getStatus()));
    }

    @Test
    public void increaseItemByIdShouldReturn404() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.put("/more/{id}", -1)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND, HttpStatus.valueOf(response.getStatus()));
    }

}
