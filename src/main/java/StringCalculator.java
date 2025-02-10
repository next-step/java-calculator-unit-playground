import java.util.regex.Pattern;


/**
 * 문자열을 숫자로 변환하여 합산하는 계산기임. <br>
 * 쉼표 또는 콜론을 기본 구분자로 사용함.<br>
 * //<구분자>\n 해당 위치에 원하는 구분자를 넣으면,<br>
 * 단일 문자로 커스텀 구분자 지정이 가능함.<br>
 * //@\n1:2@3,4 같은 형식도 처리 가능<br>
 * 음수나 숫자가 아닌 값이 포함되면 예외를 발생시킴.
 */
public class StringCalculator {

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]"; // 기본 구분자 정의

        if (input.startsWith("//")) { // 커스텀 구분자 처리 (여러 글자 지원)
            int delimiterEnd = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterEnd);
            delimiter = "[,|:]|" + Pattern.quote(customDelimiter);
            input = input.substring(delimiterEnd + 1);
        }

        Pattern pattern = Pattern.compile(delimiter);
        String[] numbers = pattern.split(input);
        return sum(numbers);
    }

    public static int sum(String[] numbers) { //문자열을 숫자로 변환하여 합을 계산
        int sum = 0;
        StringBuilder negativeNumber = new StringBuilder(); // 음수가 포함될 경우 예외메시지 만드는데 사용

        for (String num : numbers) {
            int value;

            try {
                value = Integer.parseInt(num); // parseInt 사용하여 문자열을 숫자로 변환
            } catch (NumberFormatException e) {
                // 숫자가 아닌 값이 포함되면 런타임 에러 발생
                throw new RuntimeException("Invalid input: 숫자가 아닌 값이 포함되었습니다.");
            }
            // 음수값이 발견되면 negativeNumber에 추가
            if (value < 0) {
                negativeNumber.append(value).append(" ");
            }

            sum += value;
        }
        // 음수값이 있는 경우 예외처리
        if (!negativeNumber.isEmpty()) {
            throw new RuntimeException("입력한 값 중 음수 값이 존재합니다.: " + negativeNumber.toString().trim());
        }

        return sum;
    }
}
