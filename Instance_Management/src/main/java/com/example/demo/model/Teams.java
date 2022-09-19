package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


//import net.bytebuddy.build.ToStringPlugin.Exclude;
@Entity
@Table(name = "teams")
public class Teams implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "owner")
	private String owner;
	@JsonIgnore
	@OneToMany(mappedBy = "teams", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employees;
	@JsonIgnore
	@OneToMany(mappedBy = "teams", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Instances> instances;
	public List<Instances> getInstances() {
		return instances;
	}
	public void setInstances(List<Instances> instances) {
		this.instances = instances;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/*public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	*/
}
