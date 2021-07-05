package org.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTwoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addNumbers_whenEmptyString_shouldReturnZero() throws NegativeNumberException {
        int result = CalculatorTwo.addNumbers("");
        Assert.assertEquals(0,result);
    }

    @Test
    public void addNumbers_whenNotEmptyString_shouldReturnSum() throws NegativeNumberException {
        int result = CalculatorTwo.addNumbers("1,2");
        Assert.assertEquals(result,3);
    }

    @Test
    public void addNumbers_whenMultipleStringNumbers_shouldReturnSum() throws NegativeNumberException {
        int result = CalculatorTwo.addNumbers("1,2,3,4");
        Assert.assertEquals(result,10);
    }

    @Test
    public void addNumbers_whenStringSeparatedByCommaAndSpace_shouldReturnSum() throws NegativeNumberException {
        int result = CalculatorTwo.addNumbers("1\n2,3");
        Assert.assertEquals(result,6);
    }

    @Test
    public void addNumbers_whenDynamicDelimiter_shouldReturnSum() throws NegativeNumberException {
        int result = CalculatorTwo.addNumbers("//;\n1;2");
        Assert.assertEquals(result,3);
    }

    @Test
    public void addNumbers_whenNegativeNumbers_shouldThrowExceptionVarOne() throws NegativeNumberException {
        expectedException.expect(NegativeNumberException.class);
        expectedException.expectMessage("Negatives not allowed: [-1, -2]");
        int result = CalculatorTwo.addNumbers("1\n2,-1,-2");
    }

    @Test
    public void addNumbers_whenNegativeNumbers_shouldThrowExceptionVarTwo() throws NegativeNumberException {
        expectedException.expect(NegativeNumberException.class);
        expectedException.expectMessage("Negatives not allowed: [-2]");
        int result = CalculatorTwo.addNumbers("//;\n1;-2");
    }
}