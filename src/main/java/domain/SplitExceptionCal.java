package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitExceptionCal {
    private static final String FOR_SPLIT="//|\\n";
    private static final int DISTINCTION_FRONT = 1;
    private static final int DISTINCTION_BACK = 2;

    private List<String> parsedValue = new ArrayList<>();

    public List<String> getParseInput(String input) {
        return parseInput(input);
    }    //"//;\n1;2;3"

    public List<String> getParseException(List<String> values) {
        return parseException(values);
    }

    private List<String> parseInput(String input) {
        String[] parts = input.split(FOR_SPLIT);
        String delimiter = parts[DISTINCTION_FRONT];
        String[] values = parts[DISTINCTION_BACK].split(delimiter);
        return Arrays.asList(values);
    }

    private List<String> parseException(List<String> values) {
        try {
            int parsedNumber = Integer.parseInt(values.toString());
            parsedValue.add(String.valueOf(parsedNumber));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return parsedValue;
    }
}
