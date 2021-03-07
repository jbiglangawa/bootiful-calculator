package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class NoInputValuesException extends CalculatorException {
    private static final long serialVersionUID = -7681222429153151932L;
    private static String message = "Values cannot be empty";

	public NoInputValuesException() {
		super(message);
    }
    
	public NoInputValuesException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NoInputValuesException(Throwable cause) {
		super(message, cause);
	}
}
