package com.bespoke.bitcoin.bootifulcalculator.exceptions;

public class CalculatorException extends RuntimeException {
    private static final long serialVersionUID = -1371718373864065851L;

	public CalculatorException(String message) {
		super(message);
	}
	
	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CalculatorException(Throwable cause) {
		super(cause);
	}
}
