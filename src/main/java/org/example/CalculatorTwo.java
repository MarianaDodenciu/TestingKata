package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorTwo {

    public static int addNumbers(String numbers) {
        if (numbers.isEmpty())
            return 0;
        if (numbers.contains(",")) {
            return splitNumbersByCommaAndSpace(numbers);
        }
        if (numbers.contains("//")) {
            return splitNumbersByDynamicDelimiter(numbers);
        } else
            return Integer.parseInt(numbers);
    }

    private static int splitNumbersByCommaAndSpace(String numbers) {
        int sum = 0;
        String[] numberSplited = numbers.split(",|\n");
        for (int i = 0; i < numberSplited.length; i++) {
            sum = sum + Integer.parseInt(numberSplited[i]);
        }
        return sum;
    }

    private static int splitNumbersByDynamicDelimiter(String numbers) {
        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        m.matches();
        String customDelimiter = m.group(1);
        String numbersStr = m.group(2);
        String[] nrArray = numbersStr.split(customDelimiter);
        for (int i = 0; i < nrArray.length; i++) {
            sum = sum + Integer.parseInt(nrArray[i]);
        }
        return sum;
    }
}
