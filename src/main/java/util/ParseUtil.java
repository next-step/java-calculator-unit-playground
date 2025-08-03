package util;

import exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public static List<Integer> parseNumber(String[] tokens) {
        return Arrays.stream(tokens)
            .map(ParseUtil::parseTokenToInt)
            .toList();
    }

    public static int parseTokenToInt(String token) {
        try {
            int number = Integer.parseInt(token.trim());

            if (number < 0) {
                throw new RuntimeException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
            }

            return number;
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ErrorMessage.INVALID_STRING);
        }
    }
}
