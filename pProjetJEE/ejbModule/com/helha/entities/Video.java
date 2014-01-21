package com.helha.entities;

import javax.persistence.Entity;

@Entity
public class Video extends Media {

	public Video() 
	{
		super();	
	}

	public Video(String path, String description)
	{
		super(path, description);
	}
	

}
