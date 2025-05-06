package stringCalc;

import java.util.List;


public class StringCalculator {
    public static int sumOfNumbersInString(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        ExtractedDelimiterAndBody info = CustomDelimiterAndBodyExtractor.extract(input);
        List<PositiveNumber> values = StringParser.parseStringToNumValues(info.getDelimiter(), info.getBody());

        int sum = 0;
        for (PositiveNumber positiveNumber : values) {
            sum += positiveNumber.getValue();
        }

        return sum;
    }


}
