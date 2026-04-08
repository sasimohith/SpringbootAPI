package com.amdocs.springbootcasestudy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import javax.persistence.CascadeType;
import javax.persistence.OneToMany;


@Entity
@Table(name = "DRIVER")
public class Driver {
	@Id
	@Column(name = "DNO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dno;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "CONTACT")
	private String phoneno;
	@Column(name = "LICENSE_NUMBER")
	private String licenseno;
	
	@OneToMany(mappedBy = "drivers",cascade = CascadeType.ALL)
	private Set<RouteEntity>  routeid = new HashSet<RouteEntity>();
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getLicenseno() {
		return licenseno;
	}
	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}
	public Driver() {
		super();
	}
	public Driver(int dno, String firstname, String lastname, String phoneno, String licenseno) {
		
		super();
		this.dno = dno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.licenseno = licenseno;
	}
	
}
