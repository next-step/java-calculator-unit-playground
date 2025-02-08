import java.util.Arrays;

public class StringCalculator {

    private static int[] ExpressionToTokens(String expression) {
        try {
            String tokens = expression;
            String delimiters = "[,:]";

            if (expression.contains("//") && expression.contains("\n")) {
                String customDelimiter = extractCustomDelimiter(expression);
                tokens = extractToken(expression);
                delimiters = "[,:" + customDelimiter + "]";
            }

            String[] splitTokens = tokens.split(delimiters);
            return StringArrayToIntArray(splitTokens);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Contains non-numerical values.");
        }
    }

    private static String extractCustomDelimiter(String expression) {
        int startIndex = expression.indexOf("//") + 2;
        int endIndex = expression.indexOf("\n");
        return expression.substring(startIndex, endIndex);
    }

    private static String extractToken(String expression) {
        int startIndex = expression.indexOf("//");
        int endIndex = expression.indexOf("\n");

        return expression.substring(0, startIndex) + expression.substring(startIndex + 2, endIndex) + expression.substring(endIndex + 1);
    }

    private static int[] StringArrayToIntArray(String[] expression) {
        return Arrays.stream(expression).mapToInt(Integer::parseInt).toArray();
    }

    public int add(String expression) {
        int[] tokens = ExpressionToTokens(expression);
        int answer = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            answer += tokens[i];
        }
        return answer;
    }

    public int subtract(String expression) {
        int[] tokens = ExpressionToTokens(expression);
        int answer = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            answer -= tokens[i];
        }
        return answer;
    }

    public int multiply(String expression) {
        int[] tokens = ExpressionToTokens(expression);
        int answer = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            answer *= tokens[i];
        }
        return answer;

    }

    public int divide(String expression) {
        int[] tokens = ExpressionToTokens(expression);
        int answer = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] == 0) {
                throw new ArithmeticException("Divide by zero");
            }
            answer /= tokens[i];
        }
        return answer;

    }
}

