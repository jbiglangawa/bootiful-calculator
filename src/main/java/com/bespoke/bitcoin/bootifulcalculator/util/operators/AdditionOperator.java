package com.bespoke.bitcoin.bootifulcalculator.util.operators;

import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public class AdditionOperator implements Operator {

    @Override
    public Type evaluate(List<Type> values) {
        Type sum = values.get(0);
        for(int i = 1; i < values.size(); i++) {
            sum.add(values.get(i));
        }
        return sum;
    }

}
