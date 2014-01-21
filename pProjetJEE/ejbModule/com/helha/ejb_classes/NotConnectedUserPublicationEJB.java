package com.helha.ejb_classes;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.helha.ejb_interfaces.NotConnectedUserPublicationEJBRemote;
import com.helha.entities.Production;

@Stateless
public class NotConnectedUserPublicationEJB implements NotConnectedUserPublicationEJBRemote {

	@PersistenceContext(unitName="dbg13")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Production> showAllPulications() {
		
		String requestJPQL="SELECT p FROM Production p";
		Query query = em.createQuery(requestJPQL);
		return query.getResultList();	
	}

}
