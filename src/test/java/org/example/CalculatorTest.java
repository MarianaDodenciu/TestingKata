package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.example.Calculator.addNumbers;

/**
 * Unit tests for Calculator class.
 * Naming your tests:
 * -the name of the method being tested
 * -the scenario under which it's being tested
 * -the expected behavior hen the scenario is invoked
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

    /**
     * Unit test that returns the sum of many characters delimited by comma and whitespace
     */
    @Test
    public void addNumbers_whenManyCharactersSeparatedByCommaAndNewLine_shouldReturnSum() {
        int result = addNumbers("1\n2,3\n4");
        Assert.assertEquals(10, result);
    }

    /**
     * Unit test that returns the sum of many numbers supporting different delimitators
     */
    @Test
    public void addNumbers_whenManyNumbersSeparatedByDelimitator_shouldReturnSum() {
        int result = addNumbers("//;\n1;2");
        Assert.assertEquals(3,result);
    }
}
