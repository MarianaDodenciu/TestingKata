package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.example.Calculator.addNumbers;

/**
 * Unit tests for Calculator class.
 */
public class CalculatorTest {

    /**
     * Unit test that returns value 0 if input is empty string
     */

    @Test
    public void addNumbers_whenEmptyString_shouldReturnValueZero() {
        int result = addNumbers("");
        Assert.assertEquals(0, result);
    }

    /**
     * Unit test that returns the sum of only one number
     */

    @Test
    public void addNumbers_whenOneCharacter_shouldReturnSum() {
        int result = addNumbers("22");
        Assert.assertEquals(22, result);
    }

    /**
     * Unit test that returns the sum of two numbers separated by comma
     */

    @Test
    public void addNumbers_whenTwoCharactersSeparatedByComma_shouldReturnSum() {
        int result = addNumbers("11,200");
        Assert.assertEquals(211, result);
    }

    /**
     * Unit test that returns the sum of unlimited numbers separated by comma
     */

    @Test
    public void addNumbers_whenManyCharactersSeparatedByComma_shouldReturnSum() {
        int result = addNumbers("10,20,30,40");
        Assert.assertEquals(100, result);
    }
}
