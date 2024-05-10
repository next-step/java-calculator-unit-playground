package domain;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String STANDARD_SPLIT_STRINGS = "[,|:]";
    private static final int INITIAL_NUMBER = 0;
    private static final int FIRST_NUMBER = 1;
    private static final int SECOND_NUMBER = 2;
    private static final int THIRD_NUMBER = 3;
    private static final int CUSTOM_STRING_SPLIT_NUMBER = 5;
    private static final String EXCEPTION_MINUS = "음수 입력 불가.";
    private static final String EXCEPTION_INCORRECT = "제대로 입력하세요.";
    private static final String CHECK_CUSTOM_OR_STANDARD = "/";
    private final String inputStrings;

    public StringCalculator(final String inputStrings) {
        this.inputStrings = inputStrings;
    }

    public List<String> parseStrings() {
        String checkCustomOrStandard = inputStrings.substring(INITIAL_NUMBER, FIRST_NUMBER);
        if (!checkCustomOrStandard.equals(CHECK_CUSTOM_OR_STANDARD)) {
            String[] splitStrings = inputStrings.split(STANDARD_SPLIT_STRINGS);
            return List.of(splitStrings);
        }
        String delimiter = inputStrings.substring(SECOND_NUMBER, THIRD_NUMBER);
        String divideStrings = inputStrings.substring(CUSTOM_STRING_SPLIT_NUMBER);
        String[] splitStrings = divideStrings.split(delimiter);
        return List.of(splitStrings);
    }

    public List<Integer> changeStringsToNumbers(List<String> splitStrings) {
        List<Integer> numberList = new ArrayList<>();
        try {
            for (String stringNumber : splitStrings) {
                Integer number = Integer.parseInt(stringNumber);
                numberList.add(number);
            }
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException(EXCEPTION_INCORRECT);
        }
        validateMinusNumber(numberList);
        return numberList;
    }

    private void validateMinusNumber(List<Integer> numberList) {
        for (Integer realNumber : numberList) {
            if (realNumber < INITIAL_NUMBER) {
                throw new RuntimeException(EXCEPTION_MINUS);
            }
        }
    }

    public int addNumbers(List<Integer> numberList) {
        int sum = INITIAL_NUMBER;
        for (int number : numberList) {
            sum += number;
        }
        return sum;
    }
}
