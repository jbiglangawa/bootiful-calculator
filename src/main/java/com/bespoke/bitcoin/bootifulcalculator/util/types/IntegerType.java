package com.bespoke.bitcoin.bootifulcalculator.util.types;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.IncompatibleTypeException;
import com.bespoke.bitcoin.bootifulcalculator.exceptions.TypeParseException;

public class IntegerType extends Type {
    private Integer value;

    /**
     * Empty Constructor
     */
    public IntegerType() {

    }

    public IntegerType(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new TypeParseException(Type.INTEGER, value, e);
        }
    }


    public Type parse(String value) {
        return new IntegerType(value);
    }

    @Override
    public void add(Type addend) {
        if(addend instanceof IntegerType) {
            this.value += (Integer) addend.getValue();
        }else {
            throw new IncompatibleTypeException(this, addend); 
        }
    }

    @Override
    public void subtract(Type subtrahend) {
        if(subtrahend instanceof IntegerType) {
            this.value -= (Integer) subtrahend.getValue();
        }else {
            throw new IncompatibleTypeException(this, subtrahend);
        }
    }

    @Override
    public void multiply(Type multiplier) {
        if(multiplier instanceof IntegerType) {
            this.value *= (Integer) multiplier.getValue();
        }else {
            throw new IncompatibleTypeException(this, multiplier);
        }
    }

    @Override
    public void divide(Type dividend) {
        if(dividend instanceof IntegerType) {
            this.value /= (Integer) dividend.getValue();
        }else {
            throw new IncompatibleTypeException(this, dividend);
        }
    }


    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntegerType{" +
            " value='" + getValue() + "'" +
            "}";
    }

}
