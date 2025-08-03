package domain;

import exception.ErrorMessage;
import util.DelimiterUtil;
import util.ParseUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String str) {
        if (str == null) {
            throw new RuntimeException(ErrorMessage.NULL_STRING);
        }

        if (str.isBlank())
            return 0;

        String customDelimiter = DelimiterUtil.findCustomDelimiter(str);
        String strNumbers = extractNumber(str, customDelimiter);
        String[] tokens = splitTokens(strNumbers, customDelimiter);
        List<Integer> numbers = ParseUtil.parseNumber(tokens);

        return sum(numbers);
    }

    private String extractNumber(String str, String customDelimiter) {
        if (customDelimiter != null) {
            return str.substring(str.indexOf("\n") + 1);
        }

        return str;
    }

    private String[] splitTokens(String strNumbers, String customDelimiter) {
        String delimiterRegex = "[,|:]";

        if (customDelimiter == null) {
            return strNumbers.split(delimiterRegex);
        }

        return strNumbers.split(Pattern.quote(customDelimiter));
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
