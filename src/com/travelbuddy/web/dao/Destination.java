package com.travelbuddy.web.dao;


public class Destination {

	private int id;
	private String name;
	private String description;
	
	public void showDestination() {
		System.out.println(id + ". " + name + " : " + description);
	}

	public Destination() {}
	
	public Destination(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Destination(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
