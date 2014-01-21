package com.helha.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.genericBooleanType;


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
	private Category category;
	
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
	
	
	
}
