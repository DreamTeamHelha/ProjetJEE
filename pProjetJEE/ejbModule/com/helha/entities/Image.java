package com.helha.entities;

import javax.persistence.Entity;

@Entity
public class Image extends Media{

	public Image() 
	{
		super();
	}

	public Image(String path, String description) 
	{
		super(path, description);
	}

}
