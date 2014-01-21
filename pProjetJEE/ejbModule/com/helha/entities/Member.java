package com.helha.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;




@Entity
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	
	private String name;
	private String firstname;
	private int finishYear;
	private String personnalDescription;
	private String mail;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	private boolean isAdmin;
	
	@JoinColumn(nullable=false)
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;
	
	@JoinColumn(nullable=true)
	@OneToMany(cascade = CascadeType.PERSIST)
	private ArrayList<Production> workList;

	public Member(String username, String password, String name,
			String firstname, int finishYear, String personnalDescription,
			Category category) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.firstname = firstname;
		this.finishYear = finishYear;
		this.personnalDescription = personnalDescription;
		this.category = category;
		workList = new ArrayList<Production>();
		
	}

	public Member() {
		super();
		workList = new ArrayList<Production>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getFinishYear() {
		return finishYear;
	}

	public void setFinishYear(int finishYear) {
		this.finishYear = finishYear;
	}

	public String getPersonnalDescription() {
		return personnalDescription;
	}

	public void setPersonnalDescription(String personnalDescription) {
		this.personnalDescription = personnalDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArrayList<Production> getWorkList() {
		return workList;
	}

	public void setWorkList(ArrayList<Production> workList) {
		this.workList = workList;
	}

	public int getId() {
		return id;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void addWork(Production p)
	{
		workList.add(p);
	}
	public boolean removeWork(int workId)
	{
		for(Production p : workList)
		{
			if(p.getId() == workId)
			{
				workList.remove(p);
				return true;
			}
		}
		return false;
	}
	
	public Production researchWork(String workName)
	{
		for(Production p : workList)
		{
			if(p.getName().equals(workName))
			{
				return p;
			}
		}
		return null;
	}
	
	public void modifyWork(Production p)
	{
		for(Production prod : workList)
		{
			if(p.getId()== prod.getId())
			{
				int index = workList.indexOf(prod);
				workList.remove(prod);
				workList.add(index, p);
			}
		}
	}
	
	
	
}
