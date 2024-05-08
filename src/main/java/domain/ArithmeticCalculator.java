package domain;

import java.util.ArrayList;

public class ArithmeticCalculator {

    private static final int INITIAL_NUMBER = 1;

    private final ArrayList<Integer> numbers;
    private int result;

    public ArithmeticCalculator(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public int plusCalculate() {
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    public int minusCalculate() {
        for (Integer number : numbers) {
            result -= number;
        }
        return result;
    }

    public int divideCalculate() {
        result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result /= numbers.get(i);
        }
        return result;
    }

    public int multipleCalculate() {
        result = INITIAL_NUMBER;
        for (Integer number : numbers) {
            result *= number;
        }
        return result;
    }
}
