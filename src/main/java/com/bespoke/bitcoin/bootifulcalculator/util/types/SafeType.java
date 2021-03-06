package com.bespoke.bitcoin.bootifulcalculator.util.types;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.IncompatibleTypeException;

public class SafeType extends Type {
    private Double value;

    /**
     * Empty Constructor
     */
    public SafeType() {
    }

    public SafeType(String value) {
        this.value = Double.parseDouble(value);
    }

    
    public Type parse(String value) {
        return new SafeType(value);
    }

    @Override
    public void add(Type augend) {
        if(augend instanceof SafeType) {
            this.value = Double.sum(this.value, (Double) augend.getValue());
        }else {
            throw new IncompatibleTypeException(this, augend); 
        }
    }

    

    @Override
    public void subtract(Type subtrahend) {
        if(subtrahend instanceof SafeType) {
            this.value = this.value - (Double) subtrahend.getValue();
        }else {
            throw new IncompatibleTypeException(this, subtrahend); 
        }
    }

    @Override
    public void multiply(Type multiplier) {
        if(multiplier instanceof SafeType) {
            this.value = this.value * (Double) multiplier.getValue();
        }else {
            throw new IncompatibleTypeException(this, multiplier); 
        }
    }

    @Override
    public void divide(Type dividend) {
        if(dividend instanceof SafeType) {
            this.value = this.value / (Double) dividend.getValue();
        }else {
            throw new IncompatibleTypeException(this, dividend); 
        }
    }

    
    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SafeType{" +
            " value='" + getValue() + "'" +
            "}";
    }

}
