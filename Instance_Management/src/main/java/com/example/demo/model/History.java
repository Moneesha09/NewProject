package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "used")
	private String used;
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	@Column(name = "reason")
	private String reason;
	@Column(name = "time")
	private Date time;
	@Column(name = "totime")
	private Date totime;
	public Date getTotime() {
		return totime;
	}
	public void setTotime(Date totime) {
		this.totime = totime;
	}
	@ManyToOne
	@JoinColumn(name = "instances_id")
	private Instances instances;
	public Instances getInstances() {
		return instances;
	}
	public void setInstances(Instances instances) {
		this.instances = instances;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date date) {
		this.time = date;
	}
	
	

}
