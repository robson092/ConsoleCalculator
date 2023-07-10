package org.example;

public class Calculate {
    public double add(double a, double b) {
        return a + b;
    }
    public double substract(double a, double b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        return a / b;
    }
    public double modulo(double a, double b) {
        return a % b;
    }
    public double power(double a, double b) {
        return Math.pow(a,b);
    }
    public double sqrt(double a) {
        return Math.sqrt(a);
    }
    public double pitagoras(double a, double b) {
        double powA = Math.pow(a, 2);
        double powB = Math.pow(b, 2);
        double pit = powA + powB;
        return Math.sqrt(pit);
    }
}
