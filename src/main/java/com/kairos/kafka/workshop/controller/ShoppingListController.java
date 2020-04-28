package com.kairos.kafka.workshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kairos.kafka.workshop.model.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.validation.Valid;

@Api
public interface ShoppingListController {

	@ApiOperation(value = "Return a list with all the items of the shopping list")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Shopping list items")})
	List<Item> getAllItems();

	@ApiOperation(value = "Create an item")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Item created successfully"),
			@ApiResponse(code = 400, message = "Bad request: Possibly incorrect body format")})
	Item createItem(
		@ApiParam(value = "Item to be added", required = true) @Valid Item item) throws JsonProcessingException;

	@ApiOperation(value = "Increase the quantity of the item in one unit")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Item"),
			@ApiResponse(code = 404, message = "Item not found")})
	Item increaseQuantity(
			@ApiParam(value = "Id of the item to increase", required = true) long id) throws JsonProcessingException;

	@ApiOperation(value = "Decrease the quantity of the item in one unit")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Item"),
			@ApiResponse(code = 404, message = "Item not found")})
	Item decreaseQuantity(
			@ApiParam(value = "Id of the item to decrease", required = true) long id) throws JsonProcessingException;

}