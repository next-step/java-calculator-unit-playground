package stringcalculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String START_DELIMITER = "//";
    private static final String END_DELIMITER = "\n";
    public static final String SPLIT_DELIMITER = "|";
    public static final int ADD_INDEX = 2;

    private final List<String> delimiters;

    public InputParser() {
        this.delimiters = new ArrayList<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(",");
        delimiters.add(":");
    }

    public int[] extractNumberFromInput(String input) {
        if (input.isEmpty()) {
            return new int[0];
        }

        String numbersString = input;

        if (hasCustomDelimiter(input)) {
            addCustomDelimiter(input);
            numbersString = extractNumbersPartFromInput(input);
        }

        return parseNumbersFromString(numbersString);
    }

    private int[] parseNumbersFromString(String numbersString) {
        return Arrays.stream(numbersString.split(getDelimiterPattern()))
            .filter(this::isValidNumber)
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private String extractNumbersPartFromInput(String input) {
        int delimiterEndIndex = input.indexOf(END_DELIMITER);
        return input.substring(delimiterEndIndex + 1);
    }

    private String getDelimiterPattern() {
        return delimiters.stream()
                .filter(delimiter -> !delimiter.isBlank())
                .collect(Collectors.joining(SPLIT_DELIMITER));
    }

    private void addCustomDelimiter(final String input) {
        int start = input.indexOf(START_DELIMITER) + ADD_INDEX;
        int end = input.indexOf(END_DELIMITER);

        delimiters.add(input.substring(start, end));
    }

    private boolean isValidNumber(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 입력 되었습니다.");
        }

        if (number < 0) {
            throw new RuntimeException("숫자는 음수가 될 수 없습니다.");
        }

        return true;
    }

    private boolean hasCustomDelimiter(String str) {
        return str.startsWith(START_DELIMITER);
    }
}
