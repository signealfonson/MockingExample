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
    void addNumbersOneAndTwoShouldReturnThree(){
        //Given
        String input = "1,2";
        //When
        int result = stringCalculator.add(input);
        //Then
        assertEquals(3,result);
    }
    @Test
    void addEmptyStringShouldReturnZero(){
        String input ="";

        int result = stringCalculator.add(input);

        assertEquals(0,result);
    }
    @Test
    void addOneShouldReturnOne(){
        String input = "1";

        int result = stringCalculator.add(input);

        assertEquals(1,result);

    }

    @Test
    void addTenOnesShouldReturnTen() {
        String input = "1,1,1,1,1,1,1,1,1,1";

        int result = stringCalculator.add(input);

        assertEquals(10, result);
    }
}
