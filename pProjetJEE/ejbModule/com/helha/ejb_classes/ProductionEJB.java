package com.helha.ejb_classes;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helha.ejb_interfaces.ProductionEJBRemote;
import com.helha.entities.Production;

@Stateless
public class ProductionEJB implements ProductionEJBRemote {

	@PersistenceContext(unitName="dbg3")
	private EntityManager em;
	
	@Override
	public void addPublication(Production p) {
		em.persist(p);
	}

	@Override
	public void removeProduction(Production p) {
		em.remove(em.find(Production.class, p.getId()));

	}

	@Override
	public void updateProduction(Production p) {
		em.merge(p);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Production> getProductions() {
		return em.createQuery("SELECT p FROM Production p").getResultList();
	}

}
