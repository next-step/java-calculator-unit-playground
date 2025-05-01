package utils;

import domain.Delimiters;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionSplitter {

    private final Delimiters delimiters;

    public ExpressionSplitter(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<String> split(String expression) {
        String regex = delimiters.getDelimiters().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return Arrays.asList(expression.split(regex));
    }
}
