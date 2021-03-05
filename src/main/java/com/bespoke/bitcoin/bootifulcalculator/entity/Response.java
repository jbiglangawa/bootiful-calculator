package com.bespoke.bitcoin.bootifulcalculator.entity;

import java.util.Objects;

public class Response {
    private String result;

    public Response() {
    }

    public Response(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Response result(String result) {
        setResult(result);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Response)) {
            return false;
        }
        Response response = (Response) o;
        return Objects.equals(result, response.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }

    @Override
    public String toString() {
        return "{" +
            " result='" + getResult() + "'" +
            "}";
    }

}
