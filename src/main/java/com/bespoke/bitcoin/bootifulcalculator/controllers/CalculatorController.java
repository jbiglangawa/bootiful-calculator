package com.bespoke.bitcoin.bootifulcalculator.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;
import com.bespoke.bitcoin.bootifulcalculator.util.CalculatorConstants;
import com.bespoke.bitcoin.bootifulcalculator.util.CommonUtil;
import com.bespoke.bitcoin.bootifulcalculator.util.operators.Operator;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    @PostMapping("/calculate")
    Map<String, Object> calculate(@RequestBody Equation equation) {
        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            // Get the equation type and operation
            Type equationType = Type.getType(equation.getType());
            Operator operator = Operator.getOperator(equation.getOperation());

            List<String> requestedValues = equation.getValues();
            List<Type> parsedValues = new ArrayList<Type>();
            for(String value : requestedValues) {
                parsedValues.add(equationType.parse(value));
            }
            
            Type result = operator.evaluate(parsedValues);
            response.put("result", result.getValue());
        } catch(Exception e) {
            String errorMessage = e.getMessage();
            if(CommonUtil.isEmpty(errorMessage)) {
                errorMessage = "An unknown error occurred. Please contact the system administrator";
            }
            response.put(CalculatorConstants.ERROR, errorMessage);
        }

        return response;
    }


}
