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

	@ApiOperation(value = "Checks or unchecks the item")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Item"),
			@ApiResponse(code = 404, message = "Item not found")})
	Item toggleItemCheckById(
		@ApiParam(value = "Id of the item to toggle check", required = true) long id) throws JsonProcessingException;

	@ApiOperation(value = "Create an item")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Item created successfully"),
			@ApiResponse(code = 400, message = "Bad request: Possibly incorrect body format")})
	Item createItem(
		@ApiParam(value = "Item to be added", required = true) @Valid Item item) throws JsonProcessingException;

}