package com.bah.rest_server.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	@Column(name="EVENT_ID")
	private String event_id;	
	private String customer_id;
	private Date registration_date;
	private String notes;
	
	
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(long id, String event_id, String customer_id, Date registration_date, String notes) {
		super();
		this.id = id;
		this.event_id = event_id;
		this.customer_id = customer_id;
		this.registration_date = registration_date;
		this.notes = notes;
	}
	
	public String getevent_id() {
		return event_id;
	}
	public void setevent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getcustomer_id() {
		return customer_id;
	}
	public void setcustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Date getregistration_date() {
		return registration_date;
	}
	public void setregistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
