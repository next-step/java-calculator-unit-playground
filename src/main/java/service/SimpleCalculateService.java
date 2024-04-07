package service;

import model.SimpleCalculator;

public class SimpleCalculateService {

    public int plus(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return SimpleCalculator.plus(x, y);
    }

    public int minus(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return SimpleCalculator.minus(x, y);
    }

    public int multiply(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return SimpleCalculator.multiply(x, y);
    }

    public int divide(String strX, String strY) {
        double x = parseDouble(strX);
        double y = parseDouble(strY);
        return SimpleCalculator.divide(x, y);
    }

    private double parseDouble(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(String.format("[ERROR] input 값 %s은 숫자가 아닙니다.", input));
        }
        return Double.parseDouble(input);
    }

    private boolean isNumber(String input) {
        return input != null && input.matches("[+-]?\\d+\\.?\\d*");
    }
}
