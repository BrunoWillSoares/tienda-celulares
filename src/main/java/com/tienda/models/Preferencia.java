package com.tienda.models;

import java.util.List;

public class Preferencia {
	private String id;
	private String client_id;
	private String collector_id;
	private String init_point;
	private String date_created;
	private List<Item> items;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getCollector_id() {
		return collector_id;
	}
	public void setCollector_id(String collector_id) {
		this.collector_id = collector_id;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getInit_point() {
		return init_point;
	}
	public void setInit_point(String init_point) {
		this.init_point = init_point;
	}

	
	
}