package com.techreturners.roman.numerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToNumberTest {

    private RomanToNumber romanToNumber;

    @BeforeEach
    public void setUp() {
        romanToNumber = new RomanToNumber();
    }

    @Test
    public void testRTNForValidNumber() {
        assertEquals(3, romanToNumber.getResult("III"));
        assertEquals(4, romanToNumber.getResult("IV"));
        assertEquals(6, romanToNumber.getResult("VI"));
        assertEquals(9, romanToNumber.getResult("IX"));
        assertEquals(11, romanToNumber.getResult("XI"));
    }

    @Test
    public void testRTNForInvalidNumber() {
        assertEquals(0, romanToNumber.getResult("IIX"));
        assertEquals(0, romanToNumber.getResult("IIV"));
        assertEquals(0, romanToNumber.getResult("IIIII"));
        assertEquals(0, romanToNumber.getResult("VV"));
        assertEquals(0, romanToNumber.getResult("0"));
        assertEquals(0, romanToNumber.getResult("abc"));
        assertEquals(0, romanToNumber.getResult("&*^"));
    }

    @Test
    public void testRTNForNullOrEmptyValue() {
        assertEquals(0, romanToNumber.getResult(null));
        assertEquals(0, romanToNumber.getResult(""));
    }
}
