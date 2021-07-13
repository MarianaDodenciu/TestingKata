package org.example;

import java.util.ArrayList;
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
        Matcher string = Pattern.compile("//(.{1,9})\n(.*)").matcher(numbers);
        string.matches();
        String customDelimiter = string.group(1);
        String numbersGroup = string.group(2);
        String[] numbersSplited = numbersGroup.split(Pattern.quote(customDelimiter)); //folosita ca pattern cand ai mai multe caractere
        checkNegativeNumbers(numbersSplited);
       List<Integer> remainingNumbers = checkNumbersGraterThanOneThousand(numbersSplited);

        for (Integer nr: remainingNumbers) {
            sum = sum + nr;
        }

        return sum;
    }

    private static List<Integer> checkNumbersGraterThanOneThousand(String[] numbersSplited) {
        List<Integer> originalList = Arrays.asList(numbersSplited).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList()); //transform String into Integer list
        List<Integer> originalListFiltered  = originalList.stream()
                .filter(nr -> nr >= 1000)
                .collect(Collectors.toList());
        List<Integer> differences = new ArrayList<>(originalList);

        if (originalListFiltered.size() > 0) {
            differences.removeAll(originalListFiltered);
        }
        return differences;
    }

    private static int addNumbersSeparatedByCommaAndNewLine(String numbers) throws NegativeNumberException {
        int sum = 0;
        String[] numbersArray = numbers.split(",|\n");
        checkNegativeNumbers(numbersArray);
        List<Integer> filteredList = checkNumbersGraterThanOneThousand(numbersArray);
        for (Integer nr: filteredList) {
            sum = sum + nr;
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
