package com.helha.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.helha.ejb_interfaces.CategoryEJBRemote;
import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.entities.Member;

@Named
@SessionScoped
public class UserMBean {
	
	@EJB
	private CategoryEJBRemote categoryBean;
	
	@EJB
	private MemberEJBRemote memberBean;
	
	private Member selectedMember;
	private String category;
	
	public String showWall(Member selected)
	{
		selectedMember = selected;
		return "publicwall";
	}

	public Member getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(Member selectedUser) {
		this.selectedMember = selectedUser;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<Member> getSelectedMembers(){
		 
		if(category == null  || category.isEmpty())
		{
			return memberBean.getMembers();
		}
		return memberBean.getMembers(category);
	}
	

}
