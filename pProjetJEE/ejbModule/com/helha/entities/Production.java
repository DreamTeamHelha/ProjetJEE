package com.helha.entities;

import java.util.ArrayList;

public class Production {
	
	private int id;
	private String name;
	private String description;
	private ArrayList<Media> mediaList;
	
	
	public Production() {
		super();
		this.mediaList = new ArrayList<Media>();
	}
	public Production(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.mediaList = new ArrayList<Media>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Media> getMediaList() {
		return mediaList;
	}
	public void setMediaList(ArrayList<Media> mediaList) {
		this.mediaList = mediaList;
	}
	public int getId() {
		return id;
	}
	
	

}
