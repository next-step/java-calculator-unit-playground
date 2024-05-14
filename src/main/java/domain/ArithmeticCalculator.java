package domain;

import java.util.List;

public class ArithmeticCalculator {

    private static final int INITIAL_RESULT_NUM = 0;
    private static final int INITIAL_NUMBER = 1;

    private final List<Integer> numbers;

    public ArithmeticCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int plusCalculate() {
        int result = INITIAL_RESULT_NUM;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    public int minusCalculate() {
        return numbers.stream().reduce(INITIAL_RESULT_NUM,
                (result, number) -> result - number);
    }

    public int divideCalculate() {
        int result = numbers.get(INITIAL_RESULT_NUM);
        for (int i = INITIAL_NUMBER; i < numbers.size(); i++) {
            result /= numbers.get(i);
        }
        return result;
    }

    public int multipleCalculate() {
        int result = INITIAL_NUMBER;
        for (Integer number : numbers) {
            result *= number;
        }
        return result;
    }
}
