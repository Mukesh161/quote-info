package com.cts.exceptions;

public class SsnNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SsnNotFound() {
	}
	
	public SsnNotFound(int ssn) {
		super("Quote with SSN:" + ssn + " not found");
	}

}
