package calculator;

import java.util.Arrays;

public class Calculator {

    int add(String expr) {
        int start = expr.indexOf("//");
        int end = expr.indexOf("\\n");

        String sep = "";
        if(start != -1 && end != -1 && start < end){
            sep = "[" + expr.substring(start+2, end) + "]";
            expr = expr.substring(end+2);
        } else {
            sep = "[,|:]";
        }

        String[] tokens = expr.split(sep);

        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
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
}