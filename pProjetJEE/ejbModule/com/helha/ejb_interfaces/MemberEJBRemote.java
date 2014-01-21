package com.helha.ejb_interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.helha.entities.Member;

@Remote
public interface MemberEJBRemote 
{
	public void addMember(Member m);
	public void removeMember(Member m);
	public void updateMember(Member m);
	public List<Member> getMembers();
	
	
}
