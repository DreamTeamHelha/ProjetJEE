package com.helha.ejb_interfaces;

import javax.ejb.Remote;

import java.util.List;

import com.helha.entities.Category;



@Remote
public interface CategoryEJBRemote
{
	
	public void addCategory(Category c);
	public List<Category> getCategories();
	public void removeCategory(Category c);
	public void updateCategory(Category c);

}
