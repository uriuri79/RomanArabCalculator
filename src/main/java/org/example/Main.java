package org.example;

import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        int number1, number2;
        char operation = ' ';
        int amountOperation = 0;
        int resultOfCalculate;
        String result = null;

        char[] inputChar = new char[10];
        for (int i = 0; i < input.length(); i++) {
            inputChar[i] = input.charAt(i);
            if (inputChar[i] == '+') {
                operation = '+';
                amountOperation++;
            }
            if (inputChar[i] == '-') {
                operation = '-';
                amountOperation++;
            }
            if (inputChar[i] == '*') {
                operation = '*';
                amountOperation++;
            }
            if (inputChar[i] == '/') {
                operation = '/';
                amountOperation++;
            }
        }

        if (amountOperation > 1) {
            try {
                throw new InputMismatchException("Формат математической операции не удовлетворяет условию: два операнда и один оператор");
            } catch (InputMismatchException e) {
                throw new RuntimeException(e);
            }
        }

        if (amountOperation == 0) {
            try {
                throw new InputMismatchException("Введенная строка не является математическим выражением");
            } catch (InputMismatchException e) {
                throw new RuntimeException(e);
            }
        }

        String charString = String.valueOf(inputChar);
        String[] expr = charString.split("[+-/*]");
        String expr00 = expr[0].toUpperCase();
        String expr01 = expr[1];
        String expr03 = expr01.trim().toUpperCase();

        try {
            number1 = Integer.parseInt(expr00);
            number2 = Integer.parseInt(expr03);
            resultOfCalculate = Calculator.calculate(number1, number2, operation);
            if (resultOfCalculate == -100) {
                result = "Ошибка вычисления";
            } else {
                result = number1 + " " + operation + " " + number2 + " = " + resultOfCalculate;
            }
        } catch (NumberFormatException e) {
            number1 = RomanToArab.convertRomanToArab(expr00);
            number2 = RomanToArab.convertRomanToArab(expr03);
            if (number1 < 0 || number2 < 0) {
                try {
                    throw new InputMismatchException("Используются одновременно разные системы счисления");
                } catch (InputMismatchException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                resultOfCalculate = Calculator.calculate(number1, number2, operation);
                if (resultOfCalculate == -100) {
                    System.out.println("Ошибка вычисления");
                } else {
                    String resultRoman = ArabToRoman.convertArabToRoman(resultOfCalculate);
                    result = expr00 + " " + operation + " " + expr03 + " = " + resultRoman;
                }
            }
        }
        return result;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в виде [2+2] [V+V], арабские или римские числа от 1 до 10 и нажмите Enter ");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
}