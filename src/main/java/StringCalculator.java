import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        String[] stringNumbers = convertNumber(input);

        return Arrays.stream(stringNumbers)
            .mapToInt(this::toPositiveInt)
            .sum();
    }

    private String[] convertNumber(String input) {
        if (input.isEmpty()) {
            return new String[] {"0"};
        }

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String separator = parts[0].substring(2);
            return parts[1].split(Pattern.quote(separator));
        }

        return input.split("[,|:]");
    }

    private int toPositiveInt(String value) {
        int number = Integer.parseInt(value);

        if (number < 0) {
            throw new RuntimeException("음수 입력은 허용되지 않습니다.");
        }

        return number;
    }
}
