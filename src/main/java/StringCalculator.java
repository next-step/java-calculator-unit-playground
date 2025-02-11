import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {
    private final String delimiter = ",|:";
    // (.+) : 비어있으면 안되는 1개 이상의 문자, (.*) : 비어 있어도 되는 0개 이상의 문자
    private final Pattern customDelimiterPattern = Pattern.compile("//(.+)\\n(.*)");

    int add(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자를 설정하는 (.+) 부분은 group(1)과 매칭, 뒤의 문자열은 group(2)와 매칭시킨다
        Matcher matcher = customDelimiterPattern.matcher(input);

        if(matcher.matches()) {
            String customDelimiter = delimiter + "|" + matcher.group(1);
            input = matcher.group(2);
            return sum(input.split(customDelimiter));
        }

        return sum(input.split(delimiter));
    }
    int sum(String[] numbers) {
        int sum = 0;

        for(String num : numbers) {
            if(num.isEmpty()) {
                continue;
            }

            try {
                int value = Integer.parseInt(num);
                // 음수 입력한 경우 핸들링
                if(value < 0) {
                    throw new RuntimeException("음수는 입력할 수 없습니다");
                }
                sum += value;
                // parseInt 과정에서의 오류를 잡아 숫자 이외의 것을 입력한 경우 핸들링
            } catch(NumberFormatException e) {
                throw new RuntimeException("숫자만 입력해 주세요");
            }
        }

        return sum;
    }
}
