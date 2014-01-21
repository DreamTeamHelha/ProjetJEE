package com.helha.ejb_classes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helha.ejb_interfaces.ConnectedUserInformationEJBRemote;
import com.helha.entities.Category;
import com.helha.entities.Member;

@Stateless
public class ConnectedUserInformationEJB implements ConnectedUserInformationEJBRemote {

	@PersistenceContext(unitName="dbg13")
	EntityManager em;
	@Override
	/**
	 * Méthode a supprimer peux etre car on retrouvera les infomation par des getter dans le xhtml , vue que on a le membre en cours lorsque onb rentre dans la session 
	 */
	public void showPersonnalInformations(Member m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePersonnalInformations(Member m) {
		// TODO Auto-generated method stub
		em.merge(m);
	}

}
