package com.helha.ejb_classes;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.helha.ejb_interfaces.MemberEJBRemote;
import com.helha.entities.Member;

@Stateless
public class MemberEJB implements MemberEJBRemote {

	@PersistenceContext(unitName="dbg3")
	private EntityManager em;
	
	@Override
	public void addMember(Member m) {
		em.persist(m);
	}

	@Override
	public void removeMember(Member m) {
		em.remove(em.find(Member.class,m.getId()));
	}

	@Override
	public void updateMember(Member m) {
		em.merge(m);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMembers() {
		return em.createQuery("SELECT m FROM Member m").getResultList();
	}

}
