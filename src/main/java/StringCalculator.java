import java.util.List;

public class StringCalculator {

    private final Delimiters delimiters;
    private final CustomDelimiterParser parser;
    private final CustomDelimiterRegister register;
    private final ExpressionSplitter splitter;

    public StringCalculator() {
        this.delimiters = new Delimiters();
        this.parser = new CustomDelimiterParser();
        this.register = new CustomDelimiterRegister(delimiters);
        this.splitter = new ExpressionSplitter(delimiters);
    }

    public int calculateSum(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }

        String numbersExpression = extractNumbersExpression(expression);
        List<String> tokens = splitNumbers(numbersExpression);
        NumberTokens numberTokens = new NumberTokens(tokens);

        return numberTokens.sum();
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }

    private String extractNumbersExpression(String expression) {
        if (parser.hasCustomDelimiter(expression)) {
            registerCustomDelimiter(expression);
            return extractPureNumbers(expression);
        }
        return expression;
    }

    private void registerCustomDelimiter(String expression) {
        String customDelimiter = parser.parseCustomDelimiter(expression);
        register.register(customDelimiter);
    }

    private String extractPureNumbers(String expression) {
        return parser.parseNumbersExpression(expression);
    }

    private List<String> splitNumbers(String numbersExpression) {
        return splitter.split(numbersExpression);
    }
}
