package com.bespoke.bitcoin.bootifulcalculator.services;

import java.util.ArrayList;
import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;
import com.bespoke.bitcoin.bootifulcalculator.exceptions.NoInputValuesException;
import com.bespoke.bitcoin.bootifulcalculator.util.operators.Operator;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    
    public Type calculateEquation(Equation equation) {
        if(equation.getValues() == null || equation.getValues().size() == 0) {
            throw new NoInputValuesException();
        }

        Type equationType = Type.getType(equation.getType());
        Operator operator = Operator.getOperator(equation.getOperation());

        List<Type> parsedValues = new ArrayList<Type>();
        for(String value : equation.getValues()) {
            parsedValues.add(equationType.parse(value));
        }
        
        return operator.evaluate(parsedValues);
    }

}
