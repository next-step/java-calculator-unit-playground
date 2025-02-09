import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        // null이거나 빈 문자열일 경우 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본 구분자 쉽표(,), 콜론(:)
        String delimiter = "[:,]";

        // 문자열이 "//"로 시작하면 커스텀 구분자가 정의된 상태
        if (input.startsWith("//")) {
            int newLine = input.indexOf("\n"); // "\n"의 위치를 저장

            // "\n"을 입력하지 않은 경우 예외 발생
            if (newLine == -1) {
                throw new RuntimeException("'\\n'을 입력해주세요.");
            }

            // 숫자를 입력하지 않은 경우 예외 발생
            if (newLine == input.length() - 1) {
                throw new RuntimeException(("숫자를 입력해주세요."));
            }
            delimiter = Pattern.quote(input.substring(2, newLine)); // "//" 뒤부터 "\n" 직전까지의 문자열을 구분자로 설정
            input = input.substring(newLine + 1); // "\n" 이후의 숫자 부분 추출
        }

        String[] numbers = input.split(delimiter); // 구분자를 기준으로 문자열을 분리하여 배열에 저장

        return sum(numbers); // 배열에 있는 숫자를 더해준 값을 반환
    }

    // 숫자를 합해주는 메서드
    public int sum(String[] numbers) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>(); // 음수를 저장할 리스트 (예외 발생 시 사용)
        List<String> invalidNumbers = new ArrayList<>(); // 숫자가 아닌 값 저장할 리스트(예외 발생 시 사용)

        for (String str : numbers) {
            try {
                int num = Integer.parseInt(str); // 숫자로 변환

                if (num < 0) { // 음수를 리스트에 추가
                    negatives.add(num);
                }

                sum += num;
            } catch (NumberFormatException e) {
                invalidNumbers.add(str); // 숫자가 아닌 값을 리스트에 추가
            }
        }

        // 숫자가 아닌 값이 있는 경우 예외 발생
        if (!invalidNumbers.isEmpty()) {
            throw new RuntimeException("숫자가 아닌 값이 입력되었습니다: " + invalidNumbers);
        }

        // 음수가 있는 경우 예외 발생
        if (!negatives.isEmpty()) {
            throw new RuntimeException("음수가 입력되었습니다: " + negatives);
        }

        return sum;
    }

}
