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
                res = Math.addExact(res, Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값 또는 음수를 전달할 수 없습니다.");
            } catch (ArithmeticException e) {
                throw new ArithmeticException("연산 결과가 자료형 int의 범위를 벗어났습니다.");
            }
        }

        return res;
    }
}
