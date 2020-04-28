package com.kairos.kafka.workshop.model;

import java.time.Instant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Item from the shopping cart")
public class Item {

	@ApiModelProperty(notes = "The item ID")
	private long id = -1;

	@ApiModelProperty(notes = "The item's name")
	private String name;
	@ApiModelProperty(notes = "Quantity of the item")
	private int quantity = 0;
	@ApiModelProperty(notes = "Timestamp. Get the creation EPOCH Time in milliseconds and changes with every update")
	private long updateTimestamp;

	public Item() {
	}

	public Item(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.updateTimestamp = Instant.now().toEpochMilli();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public long getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setId(long id) {
		this.id = id;
		this.updateTimestamp = Instant.now().toEpochMilli();
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTimestamp = Instant.now().toEpochMilli();
	}


	@Override
    public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity +
				", updateTimestamp=" + updateTimestamp + "]";
    }
}
