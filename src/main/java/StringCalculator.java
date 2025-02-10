import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        // 빈 문자열일 경우 0을 반환
        if (emptyCase(input)) {
            return 0;
        }

        // 문자열을 정수 리스트로 변환하고 검증하는 메서드 호출
        List<Integer> parsedNumbers = parseAndValidateNumbers(input);

        // 변환된 숫자 리스트의 합을 반환
        return sum(parsedNumbers);
    }

    // 문자열을 정수 리스트로 변환하고 검증하는 메서드
    private List<Integer> parseAndValidateNumbers(String input) {
        // 기본 구분자 쉽표(,), 콜론(:)
        String delimitersRegex = "[:,]";

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
            delimitersRegex = Pattern.quote(input.substring(2, newLine)); // "//" 뒤부터 "\n" 직전까지의 문자열을 구분자로 설정
            input = input.substring(newLine + 1); // "\n" 이후의 숫자 부분 추출
        }

        String[] numbers = splitNumbers(input, delimitersRegex); // 구분자를 기준으로 문자열을 분리하여 배열에 저장
        return convertAndValidateNumbers(numbers); // 문자열 배열을 숫자로 변환하고 검증
    }

    // 문자열을 구분자 기준으로 나누어 배열로 반환하는 메서드
    private String[] splitNumbers(String input, String delimitersRegex) {
        return input.split(delimitersRegex);
    }

    // 문자열 배열을 숫자로 변환하고 검증하는 메서드
    private List<Integer> convertAndValidateNumbers(String[] numbers) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String str : numbers) {
            int num = parseNumber(str);
            validateNegativeNumber(num);
            parsedNumbers.add(num);
        }
        return parsedNumbers;
    }

    // 빈 문자열을 입력할 경우 확인하는 메서드
    private boolean emptyCase(String input) {
        return input.isEmpty();
    }

    // 문자열을 정수로 변환하고, 숫자가 아닌 값이 입력될 경우 예외 발생 메서드
    private int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 입력되었습니다: " + str);
        }
    }

    // 숫자가 음수인 경우 예외 발생 메서드
    private void validateNegativeNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("음수가 입력되었습니다: " + num);
        }
    }

    // 정수 리스트의 합을 구하는 메서드
    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
