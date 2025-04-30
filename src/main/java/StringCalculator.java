
public class StringCalculator {

    public int calculate(String input) {

        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        // 지정 구분자
        String separator = ",|;";
        String numbers = input;

        /**
         * 커스텀 구분자 체크
         *  1. 입력받은 문자열이 //로 시작하면 \n 으로 끝나는 사이의 값을 구분자로 지정한다.
         *  2. 커스텀 구분자가 정규 표현식으로 사용되는 문자일 경우 이스케이프 처리한다.
         */
        if (input.startsWith("//")) {
            int newSeparatorIndex = input.indexOf("\n");

            String customSeparator = input.substring(2, newSeparatorIndex).trim();

            // 정규식 특수문자 앞에 /를 붙인다. [\\\\^$.|?*+()\\[\\]{}]는 정규식 특수문자를 모두 찾는 패턴, \\\\는 자바에서 \를 앞에 붙여주는 표현
            customSeparator = customSeparator.replaceAll("[\\\\^$.|?*+()\\[\\]{}]", "\\\\$0");

            separator = customSeparator;

            numbers = input.substring(newSeparatorIndex + 1).trim();
        }

        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numbersArray = numbers.split(separator);

        int sum = 0;

        for (String number : numbersArray) {
            if (!isNumeric(number)) {
                throw new RuntimeException("숫자가 아닌 값이 포함되어있습니다.");
            }

            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private boolean isNumeric(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < number.length(); i++) {
            if (i == 0 && number.charAt(i) == '-') {
                return false;
            }

            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
