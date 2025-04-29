package utils;

import domain.Delimiters;

import java.util.Arrays;
import java.util.List;

public class ExpressionSplitter {

    private final Delimiters delimiters;

    public ExpressionSplitter(Delimiters delimiters) {
        this.delimiters = delimiters;
    }

    public List<String> split(String expression) {
        List<String> delimiterList = delimiters.getDelimiters();
        String regex = String.join("|", delimiterList);
        return Arrays.asList(expression.split(regex));
    }
}
