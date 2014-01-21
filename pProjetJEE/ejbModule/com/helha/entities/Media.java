package com.helha.entities;

public abstract class Media {
	
	private int id;
	private String path;
	private String description;
	
	public Media() {
		super();
	}

	public Media(String path, String description) {
		super();
		this.path = path;
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	

}
