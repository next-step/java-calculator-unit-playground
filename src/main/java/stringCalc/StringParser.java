package stringCalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {


    public static List<NonNegativeInteger> parseStringToNumValues(String customDelimiter, String body) {
        String expression = getRegularSplitRegex(customDelimiter);
        String[] splitValues = body.split(expression);

        List<NonNegativeInteger> splitNums = Arrays.stream(splitValues)
                .map(
                        s -> {
                            try {
                                int value = Integer.parseInt(s);
                                return new NonNegativeInteger(value);
                            } catch (NumberFormatException e) {
                                throw new RuntimeException("숫자가 아닌 값이 들어왔습니다.: " + s, e);
                            }
                        }).toList();

        return splitNums;
    }

    private static String getRegularSplitRegex(String customDelimiter) {

        List<String> delimiters = new ArrayList<>(DefaultDelimiter.getSymbolsAsList());

        if (!customDelimiter.isEmpty()) {
            delimiters.add(escapeForSpecial(customDelimiter));
        }

        return "[" + String.join("|", delimiters) + "]";
    }

    private static String escapeForSpecial(String symbol) {
        if ("|.^$*+?()[]{}".contains(symbol)) {
            return "\\" + symbol;
        }
        return symbol;
    }

}
