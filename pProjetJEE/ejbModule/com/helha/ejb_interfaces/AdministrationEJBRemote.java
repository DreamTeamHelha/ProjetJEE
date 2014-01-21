package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.Member;

@Remote
public interface AdministrationEJBRemote {

	public void addMember(Member m);
	public void remove(Member m);
	public List<Member> showAllMember();
	public Member showOneMember();
	public void updateMember(Member m);
	
}
