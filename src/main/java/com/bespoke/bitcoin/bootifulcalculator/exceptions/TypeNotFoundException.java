package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class TypeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6237758059472956851L;
    private static String message = "Type cannot be found. Type should be one of the following: integer, decimal, and safe";

	public TypeNotFoundException() {
		super(message);
	}
	
	public TypeNotFoundException(String type) {
		super(message + ". Current type value: " + type);
	}
	
	public TypeNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public TypeNotFoundException(Throwable cause) {
		super(message, cause);
	}
}
