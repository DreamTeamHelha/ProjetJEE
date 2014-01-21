package com.helha.ejb_interfaces;

import javax.ejb.Remote;

import com.helha.entities.Category;
import com.helha.entities.Member;

@Remote
public interface ConnectedUserInformationEJBRemote {
	public void showPersonnalInformations(Member m);
	public void updatePersonnalInformations(Member m);
	
}
