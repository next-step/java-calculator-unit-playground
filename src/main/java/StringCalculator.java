import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    private static String delimiter = ",|:";

    public int add(String input) {
        String delimiter = this.delimiter;

        if (StringUtils.isEmpty(input)) {
            return 0;
        }

        if (hasCustomDelimiter(input)) {
            int endCustomDelimiterIndex = input.indexOf('\n');
            delimiter += "|" + input.substring(2, endCustomDelimiterIndex);
            input = input.substring(endCustomDelimiterIndex + 1);
        }

        return getSum(input.split(delimiter));
    }

    private int getSum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(num -> {
            validateIsNumber(num);
            int number = Integer.parseInt(num);
            validateIsPositive(number);
            return number;
        }).sum();
    }

    private void validateIsNumber(String number) {
        if (!isNumber(number)) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    private void validateIsPositive(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다");
        }
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private boolean isNumber(String number) {
        return number.matches("-?\\d+");
    }

}
