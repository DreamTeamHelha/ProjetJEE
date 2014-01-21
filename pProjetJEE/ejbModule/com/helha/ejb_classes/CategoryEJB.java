package com.helha.ejb_classes;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helha.ejb_interfaces.CategoryEJBRemote;
import com.helha.entities.Category;

@Stateless
public class CategoryEJB implements CategoryEJBRemote {
	
	@PersistenceContext(unitName="dbg3")
	private EntityManager em;

	@Override
	public void addCategory(Category c) {
		em.persist(c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		return em.createQuery("SELECT c FROM Category c").getResultList();
	}

	@Override
	public void removeCategory(Category c) {
		em.remove(em.find(Category.class,c.getId()));
		
	}

	@Override
	public void updateCategory(Category c) {
		em.merge(c);
		
	}

	
}
