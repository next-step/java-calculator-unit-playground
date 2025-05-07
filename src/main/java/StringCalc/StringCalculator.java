package StringCalc;

import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {

        if (input == null || input.isBlank()) return 0;

        String delimiter = DelimiterParsing.extractDelimiter(input);
        String numbersStr = DelimiterParsing.extractNumbers(input);
        String[] tokens = NumberTokens.split(numbersStr, delimiter);
        List<Integer> numbers = NumberParsing.parse(tokens);

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
