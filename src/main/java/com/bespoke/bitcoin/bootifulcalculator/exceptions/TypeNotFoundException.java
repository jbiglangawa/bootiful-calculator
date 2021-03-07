package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class TypeNotFoundException extends CalculatorException {
    private static final long serialVersionUID = 6237758059472956851L;
    private static String message = "Type cannot be found. Type should be one of the following: integer, decimal, and safe";

	public TypeNotFoundException() {
		super(message);
	}
	
	public TypeNotFoundException(String type) {
		super(message + ". Current type value: " + type);
	}
	
	public TypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TypeNotFoundException(Throwable cause) {
		super(message, cause);
	}
}
