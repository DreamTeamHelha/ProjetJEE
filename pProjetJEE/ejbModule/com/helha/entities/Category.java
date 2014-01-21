package com.helha.entities;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * Name of the category
	 */
	
	private String name;
	
	/**
	 * A Brief description of the category
	 */
	private String description;
	
	public Category(){}

	public Category(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getId()
	{
		return id;
	};
	
	
	
	

}
