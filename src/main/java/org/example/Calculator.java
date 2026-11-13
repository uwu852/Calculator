
package org.example;

public class Calculator {

    public double add(double a, double b)
            throws InvalidInputException {

        validate(a, b);
        return checkResult(a + b);
    }

    public double subtract(double a, double b)
            throws InvalidInputException {

        validate(a, b);
        return checkResult(a - b);
    }

    public double multiply(double a, double b)
            throws InvalidInputException {

        validate(a, b);
        return checkResult(a * b);
    }

    public double divide(double a, double b)
            throws InvalidInputException {

        validate(a, b);

        if (b == 0) {
            throw new ArithmeticException(
                    "Ділення на нуль заборонено"
            );
        }

        return checkResult(a / b);
    }

    public double sqrt(double a)
            throws InvalidInputException {

        validate(a);

        if (a < 0) {
            throw new InvalidInputException(
                    "Неможливо обчислити квадратний корінь від від'ємного числа"
            );
        }

        return Math.sqrt(a);
    }

    private void validate(double... numbers)
            throws InvalidInputException {

        for (double number : numbers) {
            if (!Double.isFinite(number)) {
                throw new InvalidInputException(
                        "Вхідні числа повинні бути скінченними"
                );
            }
        }
    }

    private double checkResult(double result)
            throws InvalidInputException {

        if (!Double.isFinite(result)) {
            throw new InvalidInputException(
                    "Результат виходить за допустимий діапазон"
            );
        }

        return result;
    }
}
