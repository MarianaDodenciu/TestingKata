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

    public static int addNumbers(String numbers) {

        int sum = 0;

        if (numbers.equals("")) {
            return 0;
        }

        if (!(numbers.contains(","))) {
            sum = Integer.parseInt(numbers);
        } else {
            String[] result = numbers.split(",");
            for (int i = 0; i < result.length; i++) {
                sum += Integer.parseInt(result[i]);
            }
        }

        return sum;
    }
}
