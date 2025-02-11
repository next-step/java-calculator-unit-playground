import java.util.regex.Pattern;

public class StringCalculator {

    /*
        1. 입력값 검증
        2. 구분자 추출
        3. 문자열을 구분자 기준으로 분리
        4. 분리된 숫자 문자열 배열을 합산
     */

    public int splitStrBySeparaterAndGetSum(String str) {
        // 1. 입력값 검증
        if(str.length() == 0) {
            return 0;
        }

        // 2. 구분자, 커스텀 구분자일 경우 구분자 제외 검사해야할 문자열 추출
        String separater = extractSeparater(str);
        String numbers = extractNumbers(str);

        // 3. 문자열을 구분자 기준으로 분리
        String [] tokens = numbers.split(separater);
        validateTokens(tokens);

        // 4. 분리된 숫자 문자열 배열 합산
        return calculateSum(tokens);
    }

    private String extractSeparater(String str) {
        // 기본 구분자는 , 또는 : 이다.
        String separater = "[,|:]";

        // 커스텀 구분자가 존재하는 경우
        if (str.startsWith("//") && str.contains("\n")) {
            int newLineIdx = str.indexOf("\n");
            // /n 을 찾을 수 없는 경우
            if (newLineIdx == -1) {
                throw new RuntimeException("커스텀 구분자를 '//' 와 '\\n' 문자 사이에 정확하게 입력해주세요.");
            }
            separater = Pattern.quote(str.substring(2, newLineIdx));
        }
        return separater;
    }

    private String extractNumbers(String str) {
        String numbers = "";

        // 커스텀 구분자일 경우
        if(str.startsWith("//")) {
            numbers = str.substring(str.indexOf("\n") + 1);
            return numbers;
        }

        // 기본 구분자이면 그대로 str 반환
        return str;
    }

    private void validateTokens(String[] tokens) {
        for(String token : tokens) {
            if (token.isEmpty()) {
                throw new RuntimeException("잘못된 입력 형식입니다.");
            }

            if(parseNumber(token) < 0) {
                throw new RuntimeException("음수는 사용할 수 없습니다.");
            }
        }
    }

    private int calculateSum(String[] tokens) {
        int sum = 0;
        for(String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    private int parseNumber(String number) {
        // 숫자가 아니라면 예외 발생
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");  // 정수 여부를 확인하는 정규식 (-는 음수 허용)
    }
}
