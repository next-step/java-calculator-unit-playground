package service;

import model.Calculator;

public class CalculateService {

    private static final Calculator calculator = new Calculator();

    public int plus(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return calculator.plus(x, y);
    }

    public int minus(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return calculator.minus(x, y);
    }

    public int multiply(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return calculator.multiply(x, y);
    }

    public int divide(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return calculator.divide(x, y);
    }

    private double parseDouble(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] input 값 " + input + "은 숫자가 아닙니다.");
        }
        return Double.parseDouble(input);
    }

    private boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }
}
