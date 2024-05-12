package domain;

import java.util.ArrayList;
import java.util.List;

public class SplitExceptionCal {
    private static final int CUT_NUMBER = 5;
    private static final int DISTINCTION_FRONT = 2;
    private static final int DISTINCTION_BACK = 3;

    private final List<String> parsedValue = new ArrayList<>();

    public List<String> getParsedInput(String input) {
        return parseInput(input);
    }

    public List<String> getParseException(List<String> values) {
        return parseException(values);
    }

    public List<String> parseInput(String input) {
        String delimiter = input.substring(DISTINCTION_FRONT, DISTINCTION_BACK);
        String divideStrings = input.substring(CUT_NUMBER);
        String[] splitStrings = divideStrings.split(delimiter);
        return List.of(splitStrings);
    }

    private List<String> parseException(List<String> values) {
        for (String value : values) {
            try {
                int parsedNumber = Integer.parseInt(value);
                parsedValue.add(String.valueOf(parsedNumber));
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        return parsedValue;
    }
}
