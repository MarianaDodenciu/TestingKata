package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorThree {

    public static int add(String numbers) throws NegativeNumberException {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",")) {
            return addNumbersSeparatedByCommaAndNewLine(numbers);
        }

        if (numbers.contains("//")) {
            return addNumbersSeparatedByDynamicDelimiter(numbers);
        }
        else
            return Integer.parseInt(numbers);
    }

    private static int addNumbersSeparatedByDynamicDelimiter(String numbers) throws NegativeNumberException {
        int sum = 0;
        Matcher string = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        string.matches();
        String customDelimiter = string.group(1);
        String numbersGroup = string.group(2);
        String[] numbersSplited = numbersGroup.split(customDelimiter);
        checkNegativeNumbers(numbersSplited);
       // String[] smallerNr = checkNumbersGraterThanOneThousand(numbersSplited).toArray(new String[0]);
       String[] remainingNumbers = checkNumbersGraterThanOneThousand(numbersSplited);
        for (int i = 0; i< remainingNumbers.length; i++) {
            sum = sum + Integer.parseInt(remainingNumbers[i]);
        }
        return sum;
    }

    private static String[] checkNumbersGraterThanOneThousand(String[] numbersSplited) {
        List<String> nrList = Arrays.asList(numbersSplited);
        List<Integer> smallerNumbers = nrList.stream()
                .map(s -> Integer.valueOf(s))
                .filter(nr -> nr > 1000)
                .collect(Collectors.toList());

        if (smallerNumbers.size() > 0) {
            //some logic
        }
        return numbersSplited;
    }

    private static int addNumbersSeparatedByCommaAndNewLine(String numbers) throws NegativeNumberException {
        int sum = 0;
        String[] numbersArray = numbers.split(",|\n");
        checkNegativeNumbers(numbersArray);
        for (int i = 0; i < numbersArray.length; i++) {
            sum = sum + Integer.parseInt(numbersArray[i]);
        }
        return sum;
    }

    private static void checkNegativeNumbers(String[] numbers) throws NegativeNumberException {
        List<String> nrList = Arrays.asList(numbers);
        List<Integer> negatives = nrList.stream()
                .map(s -> Integer.valueOf(s))
                .filter(nr -> nr < 0)
                .collect(Collectors.toList());

        if (negatives.size() > 0) {
            throw new NegativeNumberException("Negatives not allowed: " + negatives);
        }
    }

}
