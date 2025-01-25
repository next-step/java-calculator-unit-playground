import java.util.regex.Pattern;

public class CalculateStringData {
    public static int add(String input) {
        // null 또는 빈 문자열일 때의 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 기본적인 구분자 설정
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // '\n'의 위치 찾기
            if (delimiterIndex != -1) {
                delimiter = Pattern.quote(input.substring(2, delimiterIndex)); // 커스텀 구분자 추출
                numbers = input.substring(delimiterIndex + 1); // 숫자 부분 추출
            }
        }

        return stringSum(numbers, delimiter);
    }

    private static int stringSum(String numbers, String delimiter) {
        String[] strs = numbers.split(delimiter); // 문자열 분리

        int sum = 0;
        for (String str : strs) {
            int number = parseNumber(str); // 숫자 검증 및 변환
            checkNumber(number); // 음수 검증
            sum += number;
        }

        return sum;
    }

    // 문자열을 숫자로 변환하는 메서드
    private static int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있는 것 같아요");
        }
    }

    // 음수 검증하는 메서드
    private static void checkNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용하시면 안 돼요");
        }
    }
}
