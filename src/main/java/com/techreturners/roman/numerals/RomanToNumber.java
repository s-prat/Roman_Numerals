package com.techreturners.roman.numerals;

import java.util.Scanner;

public class RomanToNumber {

    private static final String REGEX_PATTERN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static final RomanToNumber romanToNumber = new RomanToNumber();

    public int getResult(String inputValue) {
        int result = 0;
        boolean flag = false;
        char[] charArr = inputValue.toUpperCase().toCharArray();
        int length = charArr.length;
        for(int i=0;i<length-1;i++) {
            int number1 = RomanNumerals.valueOf(String.valueOf(charArr[i])).getNumber();
            int number2 = RomanNumerals.valueOf(String.valueOf(charArr[i + 1])).getNumber();
            if (number1 >= number2) {
                result = result + number1;
                if(i+1 == length-1) {
                    flag = true;
                }
            } else {
                result = result + number2 - number1;
            }
            if(flag) {
                result = result + number2;
                flag = false;
            }
        }
        return result;
    }

    public boolean isValidRomanNumeral(String inputNumeral) {
        return inputNumeral != null && !inputNumeral.isEmpty() && inputNumeral.matches(REGEX_PATTERN);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a Roman Numeral");
        String inputValue = sc.nextLine();
        if(romanToNumber.isValidRomanNumeral(inputValue)) {
            int result = romanToNumber.getResult(inputValue);
            System.out.println("You converted the Roman Numeral " + inputValue + " to the number " + result);
        } else {
            System.out.println("This is not a valid value for Roman Numeral");
        }
        sc.close();
    }
}
