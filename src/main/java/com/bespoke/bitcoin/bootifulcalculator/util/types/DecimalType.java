package com.bespoke.bitcoin.bootifulcalculator.util.types;

import java.math.BigDecimal;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.IncompatibleTypeException;

public class DecimalType extends Type {
    private BigDecimal value;

    /**
     * Empty Constructor
     */
    public DecimalType() {

    }

    public DecimalType(String value) {
        this.value = new BigDecimal(value);
    }

    
    public Type parse(String value) {
        return new DecimalType(value);
    }

    @Override
    public void add(Type augend) {
        if(augend instanceof DecimalType) {
            this.value = this.value.add((BigDecimal) augend.getValue());
        }else {
            throw new IncompatibleTypeException(this, augend); 
        }
    }

    @Override
    public void subtract(Type subtrahend) {
        if(subtrahend instanceof DecimalType) {
            this.value = this.value.subtract((BigDecimal) subtrahend.getValue());
        }else {
            throw new IncompatibleTypeException(this, subtrahend); 
        }
    }

    @Override
    public void multiply(Type multiplier) {
        if(multiplier instanceof DecimalType) {
            this.value = this.value.multiply((BigDecimal) multiplier.getValue());
        }else {
            throw new IncompatibleTypeException(this, multiplier); 
        }
    }

    @Override
    public void divide(Type dividend) {
        if(dividend instanceof DecimalType) {
            this.value = this.value.divide((BigDecimal) dividend.getValue());
        }else {
            throw new IncompatibleTypeException(this, dividend); 
        }
    }


    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DecimalType{" +
            " value='" + getValue() + "'" +
            "}";
    }

}
