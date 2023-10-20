package com.demo.in.employeemanagementsystem.model;


import com.demo.in.employeemanagementsystem.enums.Gender;
import lombok.*;

import javax.persistence.*;

@Entity

public class Employee {


    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    public  Integer eid;

    public String ename;
    public String ecity;
    public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEcity() {
		return ecity;
	}
	public void setEcity(String ecity) {
		this.ecity = ecity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getEgender() {
		return egender;
	}
	public void setEgender(Gender egender) {
		this.egender = egender;
	}
	public Employee(Integer eid, String ename, String ecity, String email, Gender egender) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.ecity = ecity;
		this.email = email;
		this.egender = egender;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", ecity=" + ecity + ", email=" + email + ", egender="
				+ egender + ", getEid()=" + getEid() + ", getEname()=" + getEname() + ", getEcity()=" + getEcity()
				+ ", getEmail()=" + getEmail() + ", getEgender()=" + getEgender() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column
    private Gender egender;
}
