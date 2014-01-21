package com.helha.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Production {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@JoinColumn(nullable=true)
	@OneToMany(cascade=CascadeType.PERSIST)
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
	
	public void addMedia(Media m)
	{
	mediaList.add(m);
	}
	public void removeMedia(int id)
	{
		for(Media m :mediaList)
		{
			if(m.getId()==id)
			{
				mediaList.remove(m);
			}
		}
		
	}
	public Media searchMedia(int id)
	{
		for(Media m :mediaList)
		{
			if(m.getId()==id)
			{
				return m;
			}
		}
		return null;
	}
	

}
