package org.example;

/**
 * String calculator kata
 */
public class Calculator {

    public static void main(String[] args) {
    }

    /**
     * This method is used to add numbers
     *
     * @param numbers String numbers separated by comma
     * @return int This returns the sum of numbers
     */

    //TODO improve solution

    public static int addNumbers(String numbers) {

        int sum = 0;
        String delimitator = ";";

        if (numbers.equals("")) {
            return 0;
        }

        if (numbers.contains("//")) {
            String str1 = numbers.substring(2, numbers.length());
            delimitator = str1.substring(0, 1);
            String newString = str1.replaceAll("[^a-zA-Z0-9]", "");
            String[] result = newString.split("");
            for (int i = 0; i < result.length; i++) {
                sum += Integer.parseInt(result[i]);
            }
        }

        if (!(numbers.contains(",") || numbers.contains("//"))) {
            sum = Integer.parseInt(numbers);
        }
        if ((numbers.contains(",") || numbers.contains("\n") && !(numbers.contains("//")))) {
            String newString = numbers.replace("\n", ",");
            String[] result = newString.split(",");
            for (int i = 0; i < result.length; i++) {
                sum += Integer.parseInt(result[i]);
            }
        }
        return sum;
    }
}
