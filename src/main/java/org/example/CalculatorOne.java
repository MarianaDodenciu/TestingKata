package org.example;

public class CalculatorOne {

    public static int add(String numbers) throws NumberFormatException{
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.contains(",")) {
            int sum = 0;
            String[] newString = numbers.split(", |\n");
            for (int i = 0; i < newString.length; i++) {
                sum = sum + Integer.parseInt(newString[i]);
            }
            return sum;
        } else
            return Integer.parseInt(numbers);
    }

    private static int toInt(String text) throws NumberFormatException {
        return Integer.parseInt(text);
    }
}
