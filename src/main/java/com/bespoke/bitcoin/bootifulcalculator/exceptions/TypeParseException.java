package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class TypeParseException extends CalculatorException {
    private static final long serialVersionUID = 6237758059472956851L;
    private static String message = "System could not parse the value";

	public TypeParseException() {
		super(message);
	}
	
	public TypeParseException(String value) {
		super(message + ". Value: " + value);
	}
	
	public TypeParseException(String type, String value, Throwable cause) {
		super(message + ". Type: " + type + ", Value: " + value, cause);
	}
	
	public TypeParseException(Throwable cause) {
		super(message, cause);
	}
}
