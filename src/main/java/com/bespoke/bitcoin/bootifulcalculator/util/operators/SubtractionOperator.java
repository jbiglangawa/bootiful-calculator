package com.bespoke.bitcoin.bootifulcalculator.util.operators;

import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public class SubtractionOperator implements Operator {
    
    @Override
    public Type evaluate(List<Type> values) {
        Type difference = values.get(0);
        for(int i = 1; i < values.size(); i++) {
            difference.subtract(values.get(i));
        }
        return difference;
    }
    
}
