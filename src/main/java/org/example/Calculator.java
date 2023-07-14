package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);
    private double result = 0;
    private double firstNum;
    private double secondNum;
    private String operationType;

    public void runCalculator() {
        Calculate calculate = new Calculate();
        System.out.println("Welcome to console calculator!");
        System.out.println("Write EXIT to close the app.");
        System.out.println("Available operations:");
        System.out.println("""
                1. Add (+)
                2. Substract (-)
                3. Multiply (*)
                4. Divide (/)
                5. Modulo (%)
                6. Power (^)
                7. Square root (sqr)
                8. Pythagoras""");
        System.out.println("Please write first number -> enter -> operator (sing or number) -> enter -> second number");
        while (true) {
            if (result != 0 && (!sc.hasNextInt())) {
                continueIfOperandEntered();
                continue;
            }
            firstNum = sc.nextDouble();
            chooseTheOperation();
            if (ifSqrChosen()) break;
            secondNum = sc.nextDouble();
            result = switch (operationType) {
                case "1", "+" -> calculate.add(firstNum, secondNum);
                case "2", "-" -> calculate.substract(firstNum, secondNum);
                case "3", "*" -> calculate.multiply(firstNum, secondNum);
                case "4", "/" -> calculate.divide(firstNum, secondNum);
                case "5", "%" -> calculate.modulo(firstNum, secondNum);
                case "6", "^" -> calculate.power(firstNum, secondNum);
                case "7", "sqr" -> calculate.sqrt(firstNum);
                default -> 0;
            };
            System.out.println("=");
            System.out.println(result);

        }
    }

    private void chooseTheOperation() {
        do {
            operationType = sc.nextLine();
            validateIfExitChosen();
        } while (!validateOperationChosen());

    }

    private boolean validateOperationChosen() {
        List<String> oprerators = List.of("1", "+", "2", "-", "3", "*", "4", "/", "5", "%", "6", "^", "7", "sqr");
        for (String operand : oprerators) {
            if (operand.equals(operationType)) {
                return true;
            }
        }
        return false;
    }

    private void validateIfExitChosen() {
        if (operationType.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
    }

    private void continueIfOperandEntered() {
        Calculate calculate = new Calculate();
        chooseTheOperation();
        if (ifSqrChosen()) return;
        secondNum = sc.nextDouble();
        result = switch (operationType) {
            case "1", "+" -> calculate.add(result, secondNum);
            case "2", "-" -> calculate.substract(result, secondNum);
            case "3", "*" -> calculate.multiply(result, secondNum);
            case "4", "/" -> calculate.divide(result, secondNum);
            case "5", "%" -> calculate.modulo(result, secondNum);
            case "6", "^" -> calculate.power(result, secondNum);
            case "7", "sqr" -> calculate.sqrt(result);
            default -> 0;
        };
        System.out.println("=");
        System.out.println(result);
    }

    private boolean ifSqrChosen() {
        Calculate calculate = new Calculate();
        if (Objects.equals(operationType, "7") || "sqr".equals(operationType)) {
            result = calculate.sqrt(firstNum);
            System.out.println("=");
            System.out.println(result);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.runCalculator();


    }
}