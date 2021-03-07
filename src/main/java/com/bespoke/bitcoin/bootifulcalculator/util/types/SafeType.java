package com.bespoke.bitcoin.bootifulcalculator.util.types;

import java.math.BigDecimal;
import java.math.MathContext;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.IncompatibleTypeException;

public class SafeType extends Type {
    private BigDecimal value;

    /**
     * Empty Constructor
     */
    public SafeType() {
    }

    public SafeType(String value) {
        this.value = new BigDecimal(value);
    }

    
    public Type parse(String value) {
        return new SafeType(value);
    }

    @Override
    public void add(Type augend) {
        if(augend instanceof SafeType) {
            value = value.add((BigDecimal) augend.getValue());
        }else {
            throw new IncompatibleTypeException(this, augend); 
        }
    }

    @Override
    public void subtract(Type subtrahend) {
        if(subtrahend instanceof SafeType) {
            value = value.subtract((BigDecimal) subtrahend.getValue());
        }else {
            throw new IncompatibleTypeException(this, subtrahend); 
        }
    }

    @Override
    public void multiply(Type multiplier) {
        if(multiplier instanceof SafeType) {
            value = value.multiply((BigDecimal) multiplier.getValue());
        }else {
            throw new IncompatibleTypeException(this, multiplier); 
        }
    }

    @Override
    public void divide(Type dividend) {
        if(dividend instanceof SafeType) {
            value = value.divide((BigDecimal) dividend.getValue(), MathContext.DECIMAL128);
        }else {
            throw new IncompatibleTypeException(this, dividend); 
        }
    }

    
    public BigDecimal getValue() {
        return this.value.stripTrailingZeros();
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SafeType{" +
            " value='" + getValue() + "'" +
            "}";
    }

}
