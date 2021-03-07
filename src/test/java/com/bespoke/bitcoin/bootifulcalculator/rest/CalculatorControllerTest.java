package com.bespoke.bitcoin.bootifulcalculator.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bespoke.bitcoin.bootifulcalculator.util.operators.Operator;
import com.bespoke.bitcoin.bootifulcalculator.util.types.Type;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMVC;

    private static final String CALCULATE_URL = "/calculate";

    @Test
    public void basicRequestTest() throws Exception {
        mockMVC.perform(generateCalculateRequest(Operator.ADD, Type.INTEGER))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("24")));
        
    }

    /*
        Negative scenarios here
    */
    @Test
    public void integerWithDecimalNegativeTest() throws Exception {
        List<String> customValuesWithDecimals = new ArrayList<String>();
        customValuesWithDecimals.add("1.20");

        mockMVC.perform(generateCalculateRequest(customValuesWithDecimals, Operator.ADD, Type.INTEGER))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content()
                .string(Matchers.containsString("System could not parse the value. Type: integer, Value: 1.20")));

    }

    @Test
    public void integerWithLetterNegativeTest() throws Exception {
        List<String> customValuesWithDecimals = new ArrayList<String>();
        customValuesWithDecimals.add("1.20A");

        mockMVC.perform(generateCalculateRequest(customValuesWithDecimals, Operator.ADD, Type.INTEGER))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content()
                .string(Matchers.containsString("System could not parse the value. Type: integer, Value: 1.20A")));

    }

    @Test
    public void incorrectTypeNegativeTest() throws Exception {
        mockMVC.perform(generateCalculateRequest(Operator.ADD, "RandomType"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content()
                .string(Matchers.containsString("Type cannot be found. Type should be one of the following: integer, decimal, and safe. Current type value: RandomType")));
        
    }

    @Test
    public void incorrectOperatorNegativeTest() throws Exception {
        mockMVC.perform(generateCalculateRequest("RandomOperator", Type.INTEGER))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content()
                .string(Matchers.containsString("Operator cannot be found. Type should be one of the following: add, sub, mul, div. Operator value: RandomOperator")));
        
    }

    @Test
    public void emptyValuesNegativeTest() throws Exception {
        List<String> customValuesWithDecimals = new ArrayList<String>();

        mockMVC.perform(generateCalculateRequest(customValuesWithDecimals, Operator.ADD, Type.INTEGER))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Values cannot be empty")));

    }

    @Test
    public void emptyBodyNegativeTest() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.post(CALCULATE_URL))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }


    /*
        Utility methods here
    */
    public MockHttpServletRequestBuilder generateCalculateRequest(List<String> values, String operator, String type) {
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("values", values != null ? values : getDefaultValues());
        requestBody.put("operation", operator);
        requestBody.put("type", type);

        return MockMvcRequestBuilders.post(CALCULATE_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new JSONObject(requestBody).toString());

    }

    public MockHttpServletRequestBuilder generateCalculateRequest(String operator, String type) {
        return generateCalculateRequest(null, operator, type);

    }

    /**
     * The values in the array doesn't mean anything important. This
     * method is made to make coding more clean 
     * 
     * @return values
     */
    public List<String> getDefaultValues() {
        List<String> values = new ArrayList<String>();
        values.add("9");
        values.add("12");
        values.add("3");
        return values;
    }

}
