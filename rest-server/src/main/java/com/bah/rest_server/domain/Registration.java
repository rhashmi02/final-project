package com.bah.rest_server.domain;

import java.util.Date;

public class Registration {
	public Registration(long id, String title, String cutsomerName, Date date, String notes) {
		super();
		this.id = id;
		this.title = title;
		this.cutsomerName = cutsomerName;
		this.date = date;
		this.notes = notes;
	}
	private long id; 
	private String title;
	private String cutsomerName;
	private Date date;
	private String notes;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCutsomerName() {
		return cutsomerName;
	}
	public void setCutsomerName(String cutsomerName) {
		this.cutsomerName = cutsomerName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
