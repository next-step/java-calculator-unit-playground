package calculator;

public class StringCalculator {

    String[] parser(String input) {
        String delimiter;
        String contents;

        if (input.startsWith("//")) {
            char custom = input.charAt(2);
            delimiter = "[,|:" + custom + "]";
            contents = input.substring(4);
        } else {
            delimiter = "[,|:]";
            contents = input;
        }

        return new String[]{contents, delimiter};
    }

    String[] validator(String[] list) {
        String[] tokens = list[0].split(list[1]);

        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new RuntimeException("음수가 입력되었습니다.");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닌 문자열이 입력되었습니다.");
            }
        }
        return tokens;
    }

    int add(String[] tokens) {
        int result = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            result += number;
        }

        return result;
    }
}