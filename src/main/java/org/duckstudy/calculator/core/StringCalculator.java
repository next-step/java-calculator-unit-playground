package org.duckstudy.calculator.core;

import org.duckstudy.calculator.util.StringUtil;

public class StringCalculator implements Calculator<String, Integer> {
    private int result = 0;

    @Override
    public Integer add(String value) {
        if (value.isEmpty()) {
            return result;
        }

        StringBuilder delimiter = new StringBuilder(":|,");
        if (value.startsWith("//")) {
            int delimiterEndIdx = value.indexOf("\\");
            delimiter.append("|").append(value, 2, delimiterEndIdx);
            value = value.substring(delimiterEndIdx + 2);
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
        result = 0;
    }
}
