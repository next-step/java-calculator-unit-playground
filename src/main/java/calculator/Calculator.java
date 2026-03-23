package calculator;

import java.util.Arrays;

public class Calculator {
    int add(int num1, int num2) {
        return num1 + num2;
    }

    int subtract(int num1, int num2) {
        return num1 - num2;
    }

    int multiply(int num1, int num2) {
        return num1 * num2;
    }

    int divide(int num1, int num2) {
        return num1 / num2;
    }

    int add(String expr) {
        int start = expr.indexOf("//");
        int end = expr.indexOf("\\n");

        String sep = "[,|:";
        if (start != -1 && end != -1 && start < end) {
            sep += "|" + expr.substring(start + 2, end);
            expr = expr.substring(end + 2);
        }
        sep += "]";
        String[] tokens = expr.split(sep);

        try {
            return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}