package org.duckstudy.calculator.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator implements Calculator<String, Integer> {
    private static final int INITIAL_RESULT = 0;
    private final Pattern customDelimiterPattern = Pattern.compile("//(.+?)\\\\n");
    private int result;

    public StringCalculator() {
        reset();
    }

    @Override
    public Integer add(String value) {
        if (value.isEmpty()) {
            return result;
        }

        StringBuilder delimiter = new StringBuilder(":|,");
        Matcher customDelimiter = customDelimiterPattern.matcher(value);

        if (customDelimiter.find()) {
            delimiter.append("|").append(customDelimiter.group(1));
            value = value.substring(customDelimiter.end());
        }

        for (String num : value.split(delimiter.toString())) {
            if (num.startsWith("-") || !isNumberic(num)) {
                throw new RuntimeException("Invalid input");
            }
            result += Integer.parseInt(num);
        }

        return result;
    }

    public boolean isNumberic(String value) {
        return value.matches("[+]?\\d+");
    }

    @Override
    public Integer subtract(String value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Integer multiply(String value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Integer divide(String value) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void reset() {
        result = INITIAL_RESULT;
    }
}
