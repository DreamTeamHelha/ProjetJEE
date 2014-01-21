package com.helha.ejb_classes;

import java.util.List;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.helha.ejb_interfaces.ConnectedUserPublicationEJBRemote;
import com.helha.entities.Member;
import com.helha.entities.Production;

@Stateless
public class ConnectedUserPublicationEJB implements ConnectedUserPublicationEJBRemote {

	@PersistenceContext(unitName="dbg13")
	EntityManager em;
	@Override
	public void addNewPublication(Production p) {
		// TODO Auto-generated method stub
		
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Production> showAllPublication(Production p) {
		
		String requestJPQL="SELECT p FROM Production p";
		Query query = em.createQuery(requestJPQL);
		return query.getResultList();
		
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updatePublication(Production p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

}
