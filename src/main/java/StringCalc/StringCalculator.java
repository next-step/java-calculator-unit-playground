package StringCalc;

import java.util.regex.Pattern;

public class StringCalculator {


    public int add(String input) {
        // isEmpty() 대신 isBlank() 사용
        if (input == null || input.trim().isBlank()) {
            return 0;
        }

        // 변수명 명확하게 변경 및 정규표현식 사용
        String defaultDelimiterRegularExpression = "[,:]";
        String numbers = input;
        // 변수 재정의 문제점 : 하나의 변수가 여러가지 의미를 가질 수 있음 -> 코드 가독성 저하 및 혼동 발생 가능
        String delimiterRegularExpression = defaultDelimiterRegularExpression;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiterRegularExpression = Pattern.quote(parts[0].substring(2));
            numbers = parts[1];
        }

        String[] tokens = numbers.split(delimiterRegularExpression);
        int sum = 0;

        StringBuilder negatives = new StringBuilder();

        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    /*
                    isEmpty()의 부정형으로 변경 -> 보다 명확함
                    if (negatives.length() > 0) {
                        negatives.append(", ");
                    }
                    */
                    /*
                    if (!negatives.isEmpty()) {
                        negatives.append(", ");
                    }

                    negatives.append(number);
                    */
                    // 불필요한 동작 삭제
                    throw new RuntimeException("음수는 안 됩니다. 입력된 값: " + negatives);
                }
                else {
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
