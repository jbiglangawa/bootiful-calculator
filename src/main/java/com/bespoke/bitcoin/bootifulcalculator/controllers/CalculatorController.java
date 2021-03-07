package com.bespoke.bitcoin.bootifulcalculator.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;
import com.bespoke.bitcoin.bootifulcalculator.exceptions.CalculatorException;
import com.bespoke.bitcoin.bootifulcalculator.services.CalculatorService;
import com.bespoke.bitcoin.bootifulcalculator.util.CalculatorConstants;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    @Autowired
    CalculatorService calculatorService;

    @PostMapping("/calculate")
    Map<String, Object> calculate(@RequestBody Equation equation, HttpServletResponse httpResponse) {
        Map<String, Object> response = new HashMap<String, Object>();
        
        try {
            Type result = calculatorService.calculateEquation(equation);
            response.put("result", result.getValue());

        }catch(CalculatorException e) {
            response.put(CalculatorConstants.ERROR, e.getMessage());
            httpResponse.setStatus(400);

        }catch(Exception e) {
            response.put(CalculatorConstants.ERROR, "An unknown error occurred. Please contact the system administrator");
            httpResponse.setStatus(400);
        }

        return response;
    }

}
