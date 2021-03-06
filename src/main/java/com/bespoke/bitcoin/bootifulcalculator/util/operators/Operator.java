package com.bespoke.bitcoin.bootifulcalculator.util.operators;

import java.util.List;

import com.bespoke.bitcoin.bootifulcalculator.exceptions.EmptyFieldException;
import com.bespoke.bitcoin.bootifulcalculator.exceptions.OperatorNotFoundException;
import com.bespoke.bitcoin.bootifulcalculator.util.CommonUtil;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

public interface Operator {
    public static final String ADD = "add";
    public static final String SUBTRACT = "sub";
    public static final String MULTIPLY = "mul";
    public static final String DIVIDE = "div";

    public static Operator getOperator(String operator) {
        if(CommonUtil.isEmpty(operator)) {
            throw new EmptyFieldException("operator");
        }

        Operator operatorParsed;

        switch(operator) {
            case ADD:
            operatorParsed = new AdditionOperator();
                break;
            case SUBTRACT:
                operatorParsed = new SubtractionOperator();
                break;
            case MULTIPLY:
                operatorParsed = new MultiplicationOperator();
                break;
            case DIVIDE:
                operatorParsed = new DivisionOperator();
                break;
            default:
                throw new OperatorNotFoundException(operator);
        }

        return operatorParsed;
    }

    public Type evaluate(List<Type> values);

}
