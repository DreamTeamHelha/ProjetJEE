package com.helha.ejb_classes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.helha.ejb_interfaces.ConnexionEJBRemote;
import com.helha.entities.Member;


@Stateless
public class ConnexionEJB implements ConnexionEJBRemote {
	@PersistenceContext(unitName="dbg13")
	EntityManager em;
	
	private String pseudo=null;
	private String pwd=null;
	private Member m=null;
	
	
	/**
	 * Déroulement , recois le pseudo et le mdp
	 * 
	 * renvopi le membre si trouver , si non trouver renvoi null , teste a faire lors de la recuperation 
	 * 1 test le pseudo si pas trouver bey
	 * 2 test le mdp si pas trouver bey
	 * 3 retrouve la personne compatible avec pseudo et mdp si pas trouver (impossible normalement) bey
	 * si trouver renvoi la personne ainsi on c'est incformation pour les pages. suivante
	 */
	public Member connexion(String pseudo, String mdp) {
			try
			{
				String requestJpql="SELECT pseudo From Publication p where username=:pseudo";
				Query query = em.createQuery(requestJpql);
				pseudo=(String) query.getSingleResult();
			}
			catch(NoResultException e)
			{
				return null;
			}
			
			try
			{
				String requestJpql2="SELECT pseudo From Publication p where password=:mdp";
				Query query2 = em.createQuery(requestJpql2);
				pwd=(String) query2.getSingleResult();
			}
			catch(NoResultException e)
			{
				return null;
			}
			try
			{
				String requestJpql3="SELECT pseudo From Publication p where username=:pseudo and password=:mdp ";
				Query query3 = em.createQuery(requestJpql3);
				 m= (Member) query3.getSingleResult();
			}
			
			catch(NoResultException e)
			{
				return null;
			}
			
			
		
		
		return m;
	}

}
