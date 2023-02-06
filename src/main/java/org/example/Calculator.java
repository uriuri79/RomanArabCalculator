package org.example;

public class Calculator {
    public static int calculate(int num1, int num2, char op) {
        int result = 0;
        if (num1 > 10 || num2 > 10) {
            System.out.println("Веденные числа превышают допустимый предел!");
            result = -100;
        } else {
            switch (op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Деление на ноль!");
                    }
                }
                default -> throw new IllegalArgumentException("Не верный знак операции");
            }
        }
            return result;
    }
}