package com.bespoke.bitcoin.bootifulcalculator.entity;

import java.util.Objects;

public class Error {
    private String error;

    public Error() {
    }

    public Error(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Error error(String error) {
        setError(error);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Error)) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(error, error.error);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(error);
    }

    @Override
    public String toString() {
        return "{" +
            " error='" + getError() + "'" +
            "}";
    }

}
