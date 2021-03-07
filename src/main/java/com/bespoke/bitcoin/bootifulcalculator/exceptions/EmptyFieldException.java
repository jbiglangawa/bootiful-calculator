package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class EmptyFieldException extends CalculatorException {
    private static final long serialVersionUID = 2396673561223116550L;
    private static String message = "One of the fields returned is empty";

	public EmptyFieldException() {
		super(message);
	}
	
	public EmptyFieldException(String emptyField) {
		super(message + ": " + emptyField);
	}
	
	public EmptyFieldException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmptyFieldException(Throwable cause) {
		super(message, cause);
	}
}
