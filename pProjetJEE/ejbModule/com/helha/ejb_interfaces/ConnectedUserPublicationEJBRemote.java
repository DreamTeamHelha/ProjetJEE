package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.Member;
import com.helha.entities.Production;

@Remote
public interface ConnectedUserPublicationEJBRemote {
	public void addNewPublication(Production p);
	public List<Production> showAllPublication(Production p);
	public void updatePublication(Production p);
	
	
}
