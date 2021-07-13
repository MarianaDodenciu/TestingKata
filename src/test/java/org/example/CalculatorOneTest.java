package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorOneTest {

    @Test
    public void add_whenEmptyString_shouldReturnZero() {
        int result = CalculatorOne.add("");
        Assert.assertEquals(result, 0);
    }

    @Test
    public void add_whenOneNumber_shouldReturnNumber() {
        int result = CalculatorOne.add("1");
        Assert.assertEquals(result, 1);
    }

    @Test
    public void add_whenTwoNumbersSeparatedByComma_shouldReturnSum() {
        int result = CalculatorOne.add("1,2");
        Assert.assertEquals(result, 3);
    }

    @Test
    public void add_whenMultipleNumbersSeparatedByComma_shouldReturnSum() {
        int result = CalculatorOne.add("1,2,3");
        Assert.assertEquals(result, 6);
    }

    @Test
    public void add_whenMultipleNumbersSeparatedByCommaAndNewLines_shouldReturnSum() {
        int result = CalculatorOne.add("1\n2,3");
        Assert.assertEquals(result, 6);
    }
}