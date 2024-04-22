import java.util.Arrays;

public class StringCalculatorWithParser {

    private final DelimiterParser delimiterParser;

    public StringCalculatorWithParser(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int calculate(final String expression) {

        String[] operands = delimiterParser.parse(expression);

        if (operands.length == 0) {
            return 0;
        }

        return Arrays.stream(operands)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
