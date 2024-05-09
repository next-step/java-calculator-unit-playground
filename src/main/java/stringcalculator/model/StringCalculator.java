package stringcalculator.model;

import stringcalculator.exception.exceptions.OperandArgumentFormatException;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_SPLIT_REGEX = "[,|:]";
    private static final String CUSTOM_SPLITTER_PREFIX = "//";
    private static final String CUSTOM_SPLITTER_SUFFIX = "\n";
    private static final String POSITIVE_NUMBER = "0123456789";
    private static final String SPLITTER_MARK = "\\";

    public int extractSumNumbers(final String input) {
        validateIsNotNull(input);

        if (input.contains(CUSTOM_SPLITTER_PREFIX) && input.contains(CUSTOM_SPLITTER_SUFFIX)) {
            return extractSumByCustomSplitter(input);
        }
        return extractSumBySplitter(DEFAULT_SPLIT_REGEX, input);
    }

    private void validateIsNotNull(final String input) {
        if (input == null) {
            throw new OperandArgumentFormatException();
        }
    }

    private int extractSumByCustomSplitter(final String input) {
        int prefix = input.indexOf(CUSTOM_SPLITTER_PREFIX) + CUSTOM_SPLITTER_PREFIX.length() - 1;
        int suffix = input.indexOf(CUSTOM_SPLITTER_SUFFIX);
        int splitterIndex = suffix - prefix;
        String splitter = String.valueOf(input.charAt(splitterIndex));
        String inputBody = input.substring(suffix + 1);

        return extractSumBySplitter(splitter, inputBody);
    }

    private int extractSumBySplitter(final String splitter, final String input) {
        String[] tokens = input.split(convertSplitter(splitter));
        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .filter(this::isNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String convertSplitter(final String splitter) {
        if (splitter.equals(DEFAULT_SPLIT_REGEX)) {
            return splitter;
        }
        return SPLITTER_MARK + splitter;
    }

    private boolean isNumber(final String token) {
        if (!POSITIVE_NUMBER.contains(token)) {
            throw new OperandArgumentFormatException();
        }
        return true;
    }
}
