import java.util.regex.Pattern;

public class StringCalculator {

    public int getSum(String str) {

        if(str.length() == 0) {
            return 0;
        }
        int sum = 0;
        String separater = "[,|:]";
        String numbers = str;

        if (str.startsWith("//") && str.contains("\n")) {

            int newLineIdx = str.indexOf("\n");
            // /n 을 찾을 수 없거나, \n 이후 값이 없는 경우
            if (newLineIdx == -1) {
                throw new RuntimeException("잘못된 입력 형식입니다.");
            }
            separater = Pattern.quote(str.substring(2, newLineIdx));
            numbers = str.substring(newLineIdx + 1); // \n 다음부터 끝까지 숫자가 있는 부분들

            // \n 이후에 최소한 구분자가 한 개 이상은 있어야한다. 구분자가 없다면 배열 길이가 1이된다.
            if(numbers.isEmpty() || numbers.split(separater).length == 1) {
                throw new RuntimeException("잘못된 입력 형식입니다.");
            }
        }
        // 구분자를 기준으로 split 진행 후 sum 실행
        String[] tokens = numbers.split(separater);
        if(tokens.length == 1) {
            return 0;
        }
        for (String token : tokens) {
            int num = parseNumber(token);
            if (num < 0) {
                throw new RuntimeException("음수는 사용할 수 없습니다.");
            }
            sum += num;
        }

        return sum;
    }

    public int parseNumber(String number) {
        // 숫자가 아니라면 예외 발생
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
