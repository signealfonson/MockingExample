package com.example;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] splittedInputs = input.split(",");

        int sum = 0;
        for (String splittedInput : splittedInputs) {
            int convertedNumber = Integer.parseInt(splittedInput);
            sum = sum + convertedNumber;
        }
        return sum;
    }
}
