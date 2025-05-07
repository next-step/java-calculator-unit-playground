package stringcalculator;

import stringcalculator.util.InputParser;

import java.util.Arrays;

public class BasicStringCalculator implements StringCalculator {

    private final InputParser inputParser;

    public BasicStringCalculator(final InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public int add(final String str) {
        int[] numbers = inputParser.extractNumberFromInput(str);

        return Arrays.stream(numbers).sum();
    }
}

