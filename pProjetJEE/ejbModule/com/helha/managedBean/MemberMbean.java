package com.helha.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.entities.Member;

@Named
@SessionScoped
public class MemberMbean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Member currentMember;
	
	@EJB
	private MemberEJBRemote memberBean;
	
	
	public MemberMbean(){}
	
	public void updateProfil()
	{
		
	}
	public void connection()
	{
	
	}
}
