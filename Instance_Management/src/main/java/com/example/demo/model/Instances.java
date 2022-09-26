package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	@Column(name = "status")
	private Boolean status=false;
	@Column(name = "reason")
	private String reason;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee emloyee;
	 @ManyToOne
	@JoinColumn(name = "teams_id")
	private Teams teams;
		@Column(name = "used")
		private String used;
		@JsonIgnore
		@OneToMany(mappedBy = "instances", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<History> history;
	 public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}

	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}
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
	
	public Boolean getState() {
		return status;
	}
	public void setState(Boolean state) {
		this.status = state;
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
