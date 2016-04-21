package com.kennotek.resources;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class JsonTestClass {

	private long id;
	private Date date;
	private String fred;
	private String test;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFred() {
		return fred;
	}
	public void setFred(String fred) {
		this.fred = fred;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
}
