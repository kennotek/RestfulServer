package com.kennotek;

import java.util.Date;

import org.jvnet.hk2.annotations.Service;

@Service
public class TestClass implements IGetDate {
	private Date date;
	
	public TestClass() {
		this.date = new Date();
	}
	
	/* (non-Javadoc)
	 * @see com.kennotek.IGetDate#getDate()
	 */
	public Date getDate() {
		return date;
	}
}
