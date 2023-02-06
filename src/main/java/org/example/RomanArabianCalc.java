package org.example;

import java.util.Scanner;

public class RomanArabianCalc {

    public static void main (String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int number1, number2;
        char operation = ' ';
        int result;

        System.out.println("Введите выражение в виде [2+2] [V+V], арабские или римские числа от 1 до 10 и нажмите Enter ");
        String userInput = scanner.nextLine();
        char[] inputChar = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            inputChar[i] = userInput.charAt(i);
            if (inputChar[i] == '+') {
                operation = '+';
            }
            if (inputChar[i] == '-') {
                operation = '-';
            }
            if (inputChar[i] == '*') {
                operation = '*';
            }
            if (inputChar[i] == '/') {
                operation = '/';
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
            result = Calculator.calculate(number1, number2, operation);
            if (result == -100) {
                System.out.println("Ошибка вычисления");
            } else {
                System.out.println("--Результат для арабских цифр----");
                System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
            }
        } catch (NumberFormatException e) {
            number1 = RomanToArab.convertRomanToArab(expr00);
            number2 = RomanToArab.convertRomanToArab(expr03);
            if (number1 < 0 || number2 < 0) {
                throw new InputMismatchException("Неверный формат введенного выражения");
            } else {
                result = Calculator.calculate(number1, number2, operation);
                if (result == -100) {
                    System.out.println("Ошибка вычисления");
                } else {
                    System.out.println("---Результат для римских цифр----");
                    String resultRoman = ArabToRoman.convertArabToRoman(result);
                    System.out.println(expr00 + " " + operation + " " + expr03 + " = " + resultRoman);
                }
            }
        }
    }
}