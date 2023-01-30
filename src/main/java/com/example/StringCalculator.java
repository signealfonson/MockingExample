package com.example;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] splittedInputs = input.split(",");

        if (splittedInputs.length == 1) {
            return Integer.parseInt(input);
        }

        int convertedNumberOne = Integer.parseInt(splittedInputs[0]);
        int convertedNumberTwo = Integer.parseInt(splittedInputs[1]);
        return convertedNumberOne + convertedNumberTwo;
    }
}
