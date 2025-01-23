//쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
//앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
// 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
//문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

import java.util.Arrays;

public class StringCalculator {
    public static int calculate(String str) {
        String delimeter = "[,|:]";
        String[] tokens;
        int res = 0;

        if (str == null || str.isBlank()) {
            return 0;
        }

        String customDelimter = findCutstomDelimeter(str);

        if (customDelimter != null) {
            delimeter = customDelimter;
            tokens = str.substring(str.indexOf("\n") + 1).split(delimeter);
        }

        else {
            tokens = str.split(delimeter);
        }

        return sum(tokens);
    }

    public static String findCutstomDelimeter(String str) {
        int idx = 0;
        int startIdx = str.indexOf("//");
        int endIdx = str.indexOf("\n");

        if ((startIdx == -1) != (endIdx == -1) || (startIdx + 2 == endIdx)) { // 커스텀 구분자 형식인 // 과 \n 중 하나만 존재하거나 구분자가 없는 경우
            throw new RuntimeException("커스텀 구분자 형식에 맞지 않는 문자열을 전달했습니다.");
        }

        else if ((startIdx != -1)) { // 커스텀 구분자 형식인 경우
            return str.substring(startIdx + 2, endIdx);
        }

        else { // 디폴트 구분자 형식인 경우
            return null;
        }
    }

    public static int sum(String[] tokens) {
        int res = 0;

        for (String token : tokens) {
            try {
                res += Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값 또는 음수를 전달할 수 없습니다.");
            }
        }

        return res;
    }
}
