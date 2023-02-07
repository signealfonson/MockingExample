package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void beforeEveryTest() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void addNumbersOneAndTwoShouldReturnThree() {
        //Given
        String input = "1,2";
        //When
        int result = stringCalculator.add(input);
        //Then
        assertEquals(3, result);
    }

    @Test
    void addEmptyStringShouldReturnZero() {
        String input = "";

        int result = stringCalculator.add(input);

        assertEquals(0, result);
    }

    @Test
    void addOneShouldReturnOne() {
        String input = "1";

        int result = stringCalculator.add(input);

        assertEquals(1, result);

    }

    @Test
    void addTenOnesShouldReturnTen() {
        String input = "1,1,1,1,1,1,1,1,1,1";

        int result = stringCalculator.add(input);

        assertEquals(10, result);
    }

    @Test
    void numbersShouldBeAddedWithCommasAndNewLines() {
        String input = "1,2\n3";

        int result = stringCalculator.add(input);

        assertEquals(6, result);
    }

    @Test
    void numbersShouldBeAddedWithDifferentDelimitersIfWrittenBehindSlashSlash() {
        String input = "//;\n1;2";

        int result = stringCalculator.add(input);

        assertEquals(3, result);
    }

    @Test
    void addNegativeNumbersShouldThrowException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,()->stringCalculator.add("1,-2,-3"));
        assertEquals("Negatives not allowed: [-2, -3]",thrown.getMessage());
    }
    @Test
    void numbersLargerThan1000ShouldBeIgnored() {
        String input = "1001,2";

        int result = stringCalculator.add(input);

        assertEquals(2, result);
    }
    @Test
    void adjustableFormatOfDelimiter() {
        String input = "//[***]\n1***2***3";

        int result = stringCalculator.add(input);

        assertEquals(6,result);
    }
    @Test
    void enableingDifferentDilimiters() {
        String input = "//[*][%]\n1*2%3";

        int result = stringCalculator.add(input);

        assertEquals(6,result);
    }

}
