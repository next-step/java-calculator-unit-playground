package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitExceptionCal {

    private static final int DISTINCTION_FRONT = 1;
    private static final int DISTINCTION_BACK = 2;

    private List<String> parsedValue;

    private SplitExceptionCal(String input) {
        parsedValue = parseInput(input);
    }

    //"//;\n1;2;3"
    private List<String> parseInput(String input) {
        List<String> parsedValue = new ArrayList<>();
        String[] parts = input.split("//|\\n");
        String delimiter = parts[DISTINCTION_FRONT];
        String[] values = parts[DISTINCTION_BACK].split(delimiter);
        return Arrays.asList(values);
    }

    private void parseException(String value) {
        try {
            int parsedNumber = Integer.parseInt(value);
            parsedValue.add(String.valueOf(parsedNumber));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
