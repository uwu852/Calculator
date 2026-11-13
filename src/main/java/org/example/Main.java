
package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {
            System.out.println("\n=== КАЛЬКУЛЯТОР ===");
            System.out.println("1 - Додавання");
            System.out.println("2 - Віднімання");
            System.out.println("3 - Множення");
            System.out.println("4 - Ділення");
            System.out.println("5 - Квадратний корінь");
            System.out.println("0 - Вийти");
            System.out.print("Оберіть операцію: ");

            String operation = scanner.nextLine().trim();

            if (operation.equals("0")) {
                System.out.println("Роботу завершено.");
                break;
            }

            try {
                if (!operation.matches("[1-5]")) {
                    throw new InvalidInputException(
                            "Невідома операція"
                    );
                }

                System.out.print("Введіть перше число: ");
                double a = parseNumber(scanner.nextLine());

                double result;

                if (operation.equals("5")) {
                    result = calculator.sqrt(a);
                } else {
                    System.out.print("Введіть друге число: ");
                    double b = parseNumber(scanner.nextLine());

                    result = switch (operation) {
                        case "1" -> calculator.add(a, b);
                        case "2" -> calculator.subtract(a, b);
                        case "3" -> calculator.multiply(a, b);
                        case "4" -> calculator.divide(a, b);
                        default -> throw new InvalidInputException(
                                "Невідома операція"
                        );
                    };
                }

                System.out.printf(
                        Locale.US,
                        "Результат: %.4f%n",
                        result
                );

            } catch (ArithmeticException e) {
                System.out.println(
                        "Арифметична помилка: " + e.getMessage()
                );

            } catch (InvalidInputException e) {
                System.out.println(
                        "Помилка вводу: " + e.getMessage()
                );

            } finally {
                System.out.println(
                        "Обробку запиту завершено."
                );
            }
        }

        scanner.close();
    }

    public static double parseNumber(String input)
            throws InvalidInputException {

        try {
            double value = Double.parseDouble(
                    input.trim().replace(',', '.')
            );

            if (!Double.isFinite(value)) {
                throw new InvalidInputException(
                        "Число повинно бути скінченним"
                );
            }

            return value;

        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Введено не число: " + input
            );
        }
    }
}
