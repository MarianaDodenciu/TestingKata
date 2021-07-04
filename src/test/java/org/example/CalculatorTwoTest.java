package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTwoTest {

    @Test
    public void addNumbers_whenEmptyString_shouldReturnZero() {
        int result = CalculatorTwo.addNumbers("");
        Assert.assertEquals(0,result);
    }

    @Test
    public void addNumbers_whenNotEmptyString_shouldReturnSum() {
        int result = CalculatorTwo.addNumbers("1,2");
        Assert.assertEquals(result,3);
    }

    @Test
    public void addNumbers_whenMultipleStringNumbers_shouldReturnSum() {
        int result = CalculatorTwo.addNumbers("1,2,3,4");
        Assert.assertEquals(result,10);
    }

    @Test
    public void addNumbers_whenStringSeparatedByCommaAndSpace_shouldReturnSum() {
        int result = CalculatorTwo.addNumbers("1\n2,3");
        Assert.assertEquals(result,6);
    }

    @Test
    public void addNumbers_whenDynamicDelimiter_shouldReturnSum() {
        int result = CalculatorTwo.addNumbers("//;\n1;2");
        Assert.assertEquals(result,3);
    }

}