package org.duckstudy.calculator.core;

import org.duckstudy.calculator.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator implements Calculator<String, Integer> {
    private static final int INITIAL_RESULT = 0;
    private int result = INITIAL_RESULT;

    @Override
    public Integer add(String value) {
        if (value.isEmpty()) {
            return result;
        }

        StringBuilder delimiter = new StringBuilder(":|,");
        String regex = "//(.+?)\\\\n";
        Matcher customDelimiter = Pattern.compile(regex).matcher(value);

        if (customDelimiter.find()) {
            delimiter.append("|").append(customDelimiter.group(1));
            value = value.substring(customDelimiter.end());
        }

        for (String num : value.split(delimiter.toString())) {
            if (num.startsWith("-") || !StringUtil.isNumberic(num)) {
                throw new RuntimeException("Invalid input");
            }
            result += Integer.parseInt(num);
        }

        return result;
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
    public Integer divide(String value) throws ArithmeticException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void reset() {
        result = INITIAL_RESULT;
    }
}
