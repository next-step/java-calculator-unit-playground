package utils;

import domain.PositiveNumber;

public class NumberParser {

    private static final String ERROR_NOT_A_NUMBER = "[ERROR] 입력은 숫자여야 합니다.";

    public static PositiveNumber parse(String input) {
        try {
            int number = Integer.parseInt(input);
            return new PositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }
}
