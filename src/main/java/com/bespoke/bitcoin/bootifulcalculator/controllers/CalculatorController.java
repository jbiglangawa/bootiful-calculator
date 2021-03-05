package com.bespoke.bitcoin.bootifulcalculator.controllers;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    @PostMapping("/calculate")
    Equation calculate(@RequestBody Equation equation) {
        return null;
    }


}
