package utils;

import domain.Number;

public class NumberParser {

    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 입력은 숫자여야 합니다.";

    public static Number parse(String input) {
        try {
            int number = Integer.parseInt(input);
            return new Number(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }
}
