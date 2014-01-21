package com.helha.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.ejb_interfaces.ProductionEJBRemote;
import com.helha.entities.Member;
import com.helha.entities.Production;
@Named
@SessionScoped
public class AdminMBean implements Serializable{

	/*
	 * creation user
	 * remove user
	 * update user information username+pwd
	 * remove publication from user
	 * 
	 * 
	 * update profil
	 */
	
	private Member currentMember,newMember;
	private Production production ;
	@EJB
	private MemberEJBRemote memberBean;
	@EJB
	private ProductionEJBRemote productionBean;
	
	public AdminMBean()
	{
		currentMember=new Member();
		newMember=new Member();
		production= new Production(); 
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
	
	public void createMember()
	{
		memberBean.addMember(newMember);
	}
	
	public void removeMember()
	{
		memberBean.removeMember(newMember);
	}
	public void updateMember()
	{
		memberBean.updateMember(newMember);
		
	}
	public void updatePersonnal()
	{
		memberBean.updateMember(currentMember);
	}
	
	public void removeProduction(int workId)
	{
		newMember.removeWork(workId);
		memberBean.updateMember(newMember);
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



	public Member getNewMember() {
		return newMember;
	}



	public void setNewMember(Member newMember) {
		this.newMember = newMember;
	}
	
	
	
	
}
