import java.util.Arrays;

public class StringCalculator {
    private final String delimiter = ",|:";

    public int add(String input) {

        String delimiter = this.delimiter;

        if (isEmptyOrNull(input)) {
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
            if (!isNumber(num)) {
                throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다");
            }
            int number = Integer.parseInt(num);
            if (number < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다");
            }
            return number;
        }).sum();
    }

    private boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNumber(String number) {
        return number.matches("-?\\d+");
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

}
