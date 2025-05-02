package StringCalc;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = Pattern.quote(parts[0].substring(2));
            numbers = parts[1];
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        StringBuilder negatives = new StringBuilder();

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    if (negatives.length() > 0) {
                        negatives.append(", ");
                    }
                    negatives.append(number);
                } else {
                    sum += number;
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자만 입력해야 합니다.");
            }
        }

        if (negatives.length() > 0) {
            throw new RuntimeException("음수는 안 됩니다. 입력된 값: " + negatives);
        }

        return sum;
    }
}