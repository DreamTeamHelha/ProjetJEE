package com.helha.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.helha.ejb_interfaces.CategoryEJBRemote;
import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.ejb_interfaces.ProductionEJBRemote;
import com.helha.entities.Category;
import com.helha.entities.Member;
import com.helha.entities.Production;
import com.sun.enterprise.connectors.util.SetMethodAction;
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
	
	private Member currentMember, newMember;
	private Production production ;
	private Category category;
	private int categoryId;
	
	@EJB
	private MemberEJBRemote memberBean;
	@EJB
	private ProductionEJBRemote productionBean;
	
	@EJB
	private CategoryEJBRemote categoryBean;
	
	public AdminMBean()
	{
		currentMember=new Member();
		newMember=new Member();
		production= new Production();
		category = new Category();
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
		newMember = new Member();
	}
	
	public void removeMember(Member m)
	{
		setNewMember(m);
		memberBean.removeMember(newMember);
	}
	
	public String updateMember()
	{
		newMember.setCategory(categoryBean.getCategory(categoryId));
		memberBean.updateMember(newMember);
		newMember = new Member();
		return "members";
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



	public String setNewMember(Member newMember) {
		this.newMember = newMember;
		return "editmember";
	}
	
	
	public String showNewMember()
	{
		setNewMember(new Member());
		return "editmember";
	}
	
	public String showEditMember(Member member)
	{
		setNewMember(member);
		return "editmember";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String addCategory()
	{
		categoryBean.addCategory(category);
		setCategory(new Category());
		return "editsections";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
