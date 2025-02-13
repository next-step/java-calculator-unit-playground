import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    private static int[] expressionToTokens(String expression) {
        if (expression.isEmpty()) {
            return new int[]{0};
        }

        String tokens = expression;
        String delimiters = "[,:]";

        if (expression.contains("//") && expression.contains("\n")) {
            String customDelimiter = extractCustomDelimiter(expression);
            tokens = extractToken(expression);
            delimiters = "[,:]" + "|"  + customDelimiter;
        }

        String[] splitTokens = tokens.split(delimiters);
        return stringArrayToIntArray(splitTokens);
    }

    private static String extractCustomDelimiter(String expression) {
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1));
        }
        throw new IllegalArgumentException("Invalid custom delimiter format");
    }

    private static String extractToken(String expression) {
        return expression.replaceFirst("//.*?\n", ",");
    }

    private static int[] stringArrayToIntArray(String[] expression) {
        try{
            return Arrays.stream(expression).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Contains non-numerical values.");
        }
    }

    public int add(String expression) {
        int[] tokens = expressionToTokens(expression);

        int answer = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            answer += tokens[i];
        }
        return answer;
    }
}

