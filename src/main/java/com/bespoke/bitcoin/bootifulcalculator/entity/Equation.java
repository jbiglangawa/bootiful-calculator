package com.bespoke.bitcoin.bootifulcalculator.entity;

import java.util.List;
import java.util.Objects;

public class Equation {
    private List<Integer> values;
    private String operation;
    private String type;

    public Equation() {
    }

    public Equation(List<Integer> values, String operation, String type) {
        this.values = values;
        this.operation = operation;
        this.type = type;
    }

    public List<Integer> getValues() {
        return this.values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Equation values(List<Integer> values) {
        setValues(values);
        return this;
    }

    public Equation operation(String operation) {
        setOperation(operation);
        return this;
    }

    public Equation type(String type) {
        setType(type);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Equation)) {
            return false;
        }
        Equation equation = (Equation) o;
        return Objects.equals(values, equation.values) && Objects.equals(operation, equation.operation) && Objects.equals(type, equation.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, operation, type);
    }

    @Override
    public String toString() {
        return "{" +
            " values='" + getValues() + "'" +
            ", operation='" + getOperation() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
    
}
