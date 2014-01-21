package com.helha.ejb_interfaces;

import javax.ejb.Remote;

import com.helha.entities.Member;

@Remote
public interface ConnexionEJBRemote {

	
	public Member connexion(String pseudo,String mdp);
	
	
}
