package com.helha.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.ejb_interfaces.ProductionEJBRemote;
import com.helha.entities.Category;
import com.helha.entities.Member;
import com.helha.entities.Production;

@Named
@SessionScoped
public class MemberMbean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Member currentMember;

	private Production production;
	
	@EJB
	private MemberEJBRemote memberBean;
	@EJB
	private ProductionEJBRemote productionBean;

	public MemberMbean(){
	
		currentMember=new Member();
		production=new Production();
	}
	
	public void updateProfil( )
	{
		memberBean.updateMember(currentMember);
	}
	public boolean connection(String userName,String password)
	{
		boolean response=false;
		for(Member m : memberBean.getMembers() )
		{
			if(m.getUsername().equals(userName)&&m.getPassword().equals(password))
			{
				currentMember=m;
				response=true;
			}
		}
		return response;
	}

	public void addProduction()
	{
		currentMember.addWork(production);
		memberBean.updateMember(currentMember);
	}
	public void removeProduction(int workId)
	{
		currentMember.removeWork(workId);
		memberBean.updateMember(currentMember);
	}
	public void updateProduction()
	{
		productionBean.updateProduction(production);
	}
	
	public Member getCurrentMember() {
		return currentMember;
	}
	
	public void setCurrentMember(Member currentMember) {
		this.currentMember = currentMember;
	}
	

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}
}
