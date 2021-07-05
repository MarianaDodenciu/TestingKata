package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorTwo {

    public static int addNumbers(String numbers) throws NegativeNumberException {
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

    private static int splitNumbersByCommaAndSpace(String numbers) throws NegativeNumberException {
        int sum = 0;
        String[] numberSplited = numbers.split(",|\n");
        checkNegativeNumbers(numberSplited);
        for (int i = 0; i < numberSplited.length; i++) {
            sum = sum + Integer.parseInt(numberSplited[i]);
        }
        return sum;
    }

    private static int splitNumbersByDynamicDelimiter(String numbers) throws NegativeNumberException {
        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        m.matches();
        String customDelimiter = m.group(1);
        String numbersStr = m.group(2);
        String[] nrArray = numbersStr.split(customDelimiter);
        checkNegativeNumbers(nrArray);
        for (int i = 0; i < nrArray.length; i++) {
            sum = sum + Integer.parseInt(nrArray[i]);
        }
        return sum;
    }

    private static void checkNegativeNumbers(String[] numbers) throws NegativeNumberException {
        List<String> numbersList = Arrays.asList(numbers);
        List<Integer> negatives = numbersList.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number < 0)
                .collect(Collectors.toList());
        if (negatives.size() > 0) {
            throw new NegativeNumberException("Negatives not allowed: " + negatives);
        }
    }
}
