package com.kennotek;

import java.util.Date;


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
