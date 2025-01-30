import java.util.regex.*;

class StringCalculator {
    public static int calculateSum(String str) {
        String delimiter = ",;"; // 기본 구분자
        String equation = str; // 기본 문장

        String regex = "^\\/\\/(.+)\\n"; // 커스텀 구분자 분별
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // 커스텀 구분자 분별
        if (matcher.find()) {
            delimiter = matcher.group(1);
            equation = str.substring(matcher.end());
        }

        String[] numbers = equation.split("[,;" + delimiter + "]"); // 커스텀 구분자로 합 만들기

        int result = 0;
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new RuntimeException("음수가 아닌 정수를 입력해주세요");
                }

                result += num;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닙니다. 숫자를 입력해주세요.");
            }
        }

        return result;
    }
}
