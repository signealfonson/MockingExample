package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] splittedInputs;
        Pattern pattern = Pattern.compile("\\/\\/\\[(.+)\\]\\n(.+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            String[] splittedDelimiters = delimiter.split("\\]\\[");
            String delimiters = "\\Q" + String.join("\\E|\\Q", splittedDelimiters) + "\\E";
            splittedInputs = numbers.split(delimiters);
        }else if (input.startsWith("//")){
            char delimiter = input.charAt(2);
            String delimiterToString = String.valueOf(delimiter);
            String inputNumbers = input.substring(4);
            splittedInputs = inputNumbers.split("\\Q" + delimiterToString + "\\E");

        } else{
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
