package com.creditsuisse.rest.exceptions;

public class BussinesException extends Exception {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 7990200694848865721L;

	public BussinesException(Throwable e) {
	       super(e);
	    }
	 
	    
	     public BussinesException(String message) {
	       super(message);
	    }
	    
	    public BussinesException(String message, Throwable throwable) {
	       super(message, throwable);
	    } 
	
	
	
}
