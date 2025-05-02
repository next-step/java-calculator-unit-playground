package stringCalc;

import java.util.List;

import static stringCalc.ValueValidator.validate;

public class StringParser {

    public static List<String> parse(String customDelimiter, String body) {
        String expression = getRegularSplitRegex(customDelimiter);
        String[] split_nums = body.split(expression);
        ValueValidator.validate(List.of(split_nums));
        return List.of(split_nums);
    }

    private static String getRegularSplitRegex(String customDelimiter) {
        StringBuilder ex = new StringBuilder();

        ex.append("[");
        for (String del : DefaultDelimiter.getSymbolsAsList()) {
            ex.append(del);
            ex.append("|");
        }

        if (!customDelimiter.isEmpty()) {
            ex.append(escapeForSpecial(customDelimiter));
        } else {
            // 마지막 '|' 제거
            ex.setLength(ex.length() - 1);
        }

        ex.append("]");

        return ex.toString();
    }

    private static String escapeForSpecial(String symbol) {
        if ("|.^$*+?()[]{}".contains(symbol)) {
            return "\\" + symbol;
        }
        return symbol;
    }

}
