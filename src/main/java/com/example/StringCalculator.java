package com.example;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] splittedInputs = input.split(",");
        int convertedNumberOne = Integer.parseInt(splittedInputs[0]);
        int convertedNumberTwo = Integer.parseInt(splittedInputs[1]);
        return convertedNumberOne + convertedNumberTwo;
    }
}
