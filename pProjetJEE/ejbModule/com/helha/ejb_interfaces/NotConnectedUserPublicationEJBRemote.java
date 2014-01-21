package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.Production;

@Remote
public interface NotConnectedUserPublicationEJBRemote {

	public List<Production> showAllPulications();
	
	
}
