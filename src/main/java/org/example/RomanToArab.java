package org.example;

import java.util.InputMismatchException;

public class RomanToArab {
    public static int convertRomanToArab (String roman) {
        //roman = roman.toUpperCase();
        try {
            switch (roman) {
                case "I" ->    { return 1; }
                case "II" ->   { return 2; }
                case "III" ->  { return 3; }
                case "IV" ->   { return 4; }
                case "V" ->    { return 5; }
                case "VI" ->   { return 6; }
                case "VII" ->  { return 7; }
                case "VIII" -> { return 8; }
                case "IX" ->   { return 9; }
                case "X" ->    { return 10;}
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
}
