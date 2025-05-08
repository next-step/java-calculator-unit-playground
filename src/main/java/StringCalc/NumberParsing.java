package StringCalc;

import java.util.ArrayList;
import java.util.List;

public class NumberParsing {
    public static List<Integer> parse(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new RuntimeException("구분자 사이에 값이 없습니다.");
            }

            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new RuntimeException("음수는 안 됩니다. 입력된 값: " + number);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자만 입력해야 합니다.");
            }
        }

        return numbers;
    }
}
