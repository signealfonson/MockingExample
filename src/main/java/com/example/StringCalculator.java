package com.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] splittedInputs;
        if (input.startsWith("//")){
            char delimiter = input.charAt(2);
            String delimiterToString = String.valueOf(delimiter);
            String inputNumbers = input.substring(4);
            splittedInputs = inputNumbers.split(delimiterToString);
        }
        else{
            splittedInputs = input.split(",|\n");
        }

        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String splittedInput : splittedInputs) {
            int convertedNumber = Integer.parseInt(splittedInput);
            if(convertedNumber > 1000){
                continue;
            }
            sum = sum + convertedNumber;

            if(convertedNumber < 0){
                negativeNumbers.add(convertedNumber);
            }
        }
        if(!negativeNumbers.isEmpty()){
            String message = "Negatives not allowed: " + negativeNumbers.toString();
            throw new RuntimeException(message);
        }

        return sum;
    }
}
