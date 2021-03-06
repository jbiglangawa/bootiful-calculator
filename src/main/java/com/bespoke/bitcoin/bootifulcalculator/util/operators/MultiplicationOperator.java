package com.bespoke.bitcoin.bootifulcalculator.util.operators;

import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public class MultiplicationOperator implements Operator {
    
    @Override
    public Type evaluate(List<Type> values) {
        Type product = values.get(0);
        for(int i = 1; i < values.size(); i++) {
            product.multiply(values.get(i));
        }
        return product;
    }
}
