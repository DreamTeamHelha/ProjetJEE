package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.Production;

@Remote
public interface PublicationEJBRemote {

	public void addPublication(Production p);
	public void removeProduction(Production p);
	public void updateProduction(Production p);
	public List<Production> getProductions();
	
}
