package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void beforeEveryTest(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void addNumbersOneAndTwoAndReturnThree(){
        //Given
        String input = "1,2";
        //When
        int result = stringCalculator.add(input);
        //Then
        assertEquals(3,result);

    }
}
