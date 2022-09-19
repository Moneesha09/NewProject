package com.example.demo.model;

import java.io.Serializable;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "instances")

public class Instances implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "state")
	private String state;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee emloyee;
	 @ManyToOne
	@JoinColumn(name = "teams_id")
	private Teams teams;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Employee getEmloyee() {
		return emloyee;
	}
	public void setEmloyee(Employee emloyee) {
		this.emloyee = emloyee;
	}
	public Teams getTeams() {
		return teams;
	}
	public void setTeams(Teams teams) {
		this.teams = teams;
	}
	

}
