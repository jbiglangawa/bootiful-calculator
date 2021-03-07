package com.bespoke.bitcoin.bootifulcalculator.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.entity.Equation;
import com.bespoke.bitcoin.bootifulcalculator.util.operators.Operator;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServicetest {

    @Autowired
    CalculatorService calculatorService;

    /*
        Integer tests
    */
    @Test
    public void integerAdditionTest() {
        Type result = generateIntegerTestData(Operator.ADD);
        assertEquals(29, result.getValue());
    }

    @Test
    public void integerSubtractionTest() {
        Type result = generateIntegerTestData(Operator.SUBTRACT);
        assertEquals(-11, result.getValue());
    }

    @Test
    public void integerMultiplicationTest() {
        Type result = generateIntegerTestData(Operator.MULTIPLY);
        assertEquals(459, result.getValue());
    }

    @Test
    public void integerDivisionTest() {
        Type result = generateIntegerTestData(Operator.DIVIDE, "1000");
        assertEquals(2, result.getValue());    
    }

    /*
        Decimal tests
    */
    @Test
    public void decimalAdditionTest() {
        Type result = generateDecimalTestData(Operator.ADD);
        assertEquals(Double.parseDouble("643.938432"), result.getValue());
    }

    @Test
    public void decimalSubtractionTest() {
        Type result = generateDecimalTestData(Operator.SUBTRACT);
        assertEquals(Double.parseDouble("-625.32757"), result.getValue());
    }

    @Test
    public void decimalMultiplicationTest() {
        Type result = generateDecimalTestData(Operator.MULTIPLY);
        assertEquals(Double.parseDouble("20613.78493970716"), result.getValue());
    }

    @Test
    public void decimalDivisionTest() {
        Type result = generateDecimalTestData(Operator.DIVIDE);
        assertEquals(Double.parseDouble("0.004200637891053458"), result.getValue());
    }

    /*
        Safe tests
    */
    @Test
    public void safeAdditionTest() {
        Type result = generateSafeTestData(Operator.ADD);
        assertEquals(new BigDecimal("54.611"), result.getValue());
    }
    
    @Test
    public void safeSubtractionTest() {
        Type result = generateSafeTestData(Operator.SUBTRACT);
        assertEquals(new BigDecimal("46.911"), result.getValue());
    }

    @Test
    public void safeMultiplicationTest() {
        Type result = generateSafeTestData(Operator.MULTIPLY);
        assertEquals(new BigDecimal("178.932525"), result.getValue());
    }

    @Test
    public void safeDivisionTest() {
        Type result = generateSafeTestData(Operator.DIVIDE);
        assertEquals(new BigDecimal("14.40028368794326241134751773049646"), result.getValue());
    }


    /*
        Utility methods
    */
    public Type generateIntegerTestData(String operation) {
        return generateIntegerTestData(operation, null);
    }

    public Type generateIntegerTestData(String operation, String customPrefixValue) {
        List<String> values = new ArrayList<String>();

        if(customPrefixValue != null) {
            values.add(customPrefixValue);
        }

        values.add("9");
        values.add("17");
        values.add("3");

        Equation equation = new Equation(values, operation, Type.INTEGER);
        return calculatorService.calculateEquation(equation);
    }

    public Type generateDecimalTestData(String operation) {
        List<String> values = new ArrayList<String>();
        values.add("9.305431");
        values.add("631.123");
        values.add("3.510001");

        Equation equation = new Equation(values, operation, Type.DECIMAL);
        return calculatorService.calculateEquation(equation);
    }

    public Type generateSafeTestData(String operation) {
        List<String> values = new ArrayList<String>();
        values.add("50.761");
        values.add("1.50");
        values.add("2.35");

        Equation equation = new Equation(values, operation, Type.SAFE);
        return calculatorService.calculateEquation(equation);
    }
}
