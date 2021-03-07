package com.bespoke.bitcoin.bootifulcalculator.services;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public interface CalculatorService {
    
    public Type calculateEquation(Equation equation);
    
}
