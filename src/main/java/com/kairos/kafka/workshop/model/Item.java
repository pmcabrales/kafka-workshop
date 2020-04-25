package com.kairos.kafka.workshop.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Item from the shopping cart")
public class Item {

	@ApiModelProperty(notes = "The item ID")
	private long id = -1;

	@ApiModelProperty(notes = "The item's name")
	private String name;
	@ApiModelProperty(notes = "True to mark item as checked")
	private boolean checked;
	@ApiModelProperty(notes = "Timestamp. Get the creation EPOCH Time in milliseconds and changes with every update")
	private long update_ts;

	public Item() {
	}

	public Item(String name, boolean checked) {
		super();
		this.name = name;
		this.checked = checked;
		this.update_ts = Instant.now().toEpochMilli();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isChecked() {
		return checked;
	}

	public long getUpdate_ts() {
		return update_ts;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setUpdate_ts(long update_ts) {
		this.update_ts = update_ts;
	}

	@Override
    public String toString() {
		return "Item [id=" + id + ", name=" + name + ", checked=" + checked + "]";
    }
}
