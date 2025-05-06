package stringCalc;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static List<String> parseStringToNumValues(String customDelimiter, String body) {
        String expression = getRegularSplitRegex(customDelimiter);
        String[] split_nums = body.split(expression);
        ValueValidator.validate(List.of(split_nums));
        return List.of(split_nums);
    }

    private static String getRegularSplitRegex(String customDelimiter) {

        List<String> delimiters = new ArrayList<>(DefaultDelimiter.getSymbolsAsList());

        if(!customDelimiter.isEmpty()){
            delimiters.add(escapeForSpecial(customDelimiter));
        }

        return "[" + String.join("|",delimiters) + "]";
    }

    private static String escapeForSpecial(String symbol) {
        if ("|.^$*+?()[]{}".contains(symbol)) {
            return "\\" + symbol;
        }
        return symbol;
    }

}
