package com.bespoke.bitcoin.bootifulcalculator.exceptions;

import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public class IncompatibleTypeException extends CalculatorException {
    private static final long serialVersionUID = -7681222429153151932L;
    private static String message = "The current type is incompatible with the other type";

	public IncompatibleTypeException() {
		super(message);
    }
    
    public IncompatibleTypeException(Type type1, Type type2) {
        super(message + "; First Type: " + type1 + ", Second Type: " + type2);
    }
	
	public IncompatibleTypeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IncompatibleTypeException(Throwable cause) {
		super(message, cause);
	}
}
