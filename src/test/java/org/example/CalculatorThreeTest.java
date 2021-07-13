package org.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorThreeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void add_whenEmptyString_shouldReturnZero() throws NegativeNumberException {
        Assert.assertEquals(0,CalculatorThree.add(""));
    }

    @Test
    public void add_whenOneNumber_shouldReturnTheNumber() throws NegativeNumberException {
        Assert.assertEquals(1,CalculatorThree.add("1"));
    }

    @Test
    public void add_whenNumbersSeparatedByComma_shouldReturnSum() throws NegativeNumberException {
        Assert.assertEquals(3,CalculatorThree.add("1,2"));
    }

    @Test
    public void add_whenMultipleNumbersSeparatedByComma_shouldReturnSum() throws NegativeNumberException {
        Assert.assertEquals(5,CalculatorThree.add("1,2,1,1"));
    }

    @Test
    public void add_whenNumbersSeparatedByCommaAndNewLine_shouldReturnSum() throws NegativeNumberException {
        Assert.assertEquals(6,CalculatorThree.add("1\n2,3"));
    }

    @Test
    public void add_whenDynamicDelimiter_shouldReturnSum() throws NegativeNumberException {
        Assert.assertEquals(3,CalculatorThree.add("//;\n1;2"));
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

    @Test
    public void addNumbers_whenNumbersGraterThanOneThousand_shouldReturnSumWithoutThem() throws NegativeNumberException {
        Assert.assertEquals(1,CalculatorThree.add("//;\n1;1000"));
    }

    @Test
    public void addNumbers_whenNumbersGraterThanOneThousandAndSplitedByCommaAndNewLine_shouldReturnSumWithoutThem() throws NegativeNumberException {
        Assert.assertEquals(1,CalculatorThree.add("1,1000"));
    }

    /**
     * Delimiters can be of any length
     */
    @Test
    public void addNumbers_whenDynamicDelimiterOfAnyLength_shouldReturnSum() throws NegativeNumberException {
        Assert.assertEquals(6,CalculatorThree.add("//***\n1***2***3"));
    }
}
