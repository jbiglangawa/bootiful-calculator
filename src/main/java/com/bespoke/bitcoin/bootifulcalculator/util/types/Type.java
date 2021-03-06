package com.bespoke.bitcoin.bootifulcalculator.util.types;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.EmptyFieldException;
import com.bespoke.bitcoin.bootifulcalculator.exceptions.TypeNotFoundException;
import com.bespoke.bitcoin.bootifulcalculator.util.CommonUtil;

public abstract class Type {
    public static final String INTEGER = "integer";
    public static final String DECIMAL = "decimal";
    public static final String SAFE = "safe";

    private Object value;
    protected String type;

    /**
     * Empty constructor
     */
    public Type() {
        
    }

    public static Type getType(String type) {
        if(CommonUtil.isEmpty(type)) {
            throw new EmptyFieldException("type");
        }

        switch(type) {
            case INTEGER:
                return new IntegerType();
            case DECIMAL:
                return new DecimalType();
            case SAFE:
                return new SafeType();
            default:
                throw new TypeNotFoundException(type);
        }
    }

    public abstract Type parse(String value);

    public abstract void add(Type addend);
    
    public abstract void subtract(Type subtrahend);

    public abstract void multiply(Type multiplier);

    public abstract void divide(Type dividend);

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return this.type;
    }
    

}
