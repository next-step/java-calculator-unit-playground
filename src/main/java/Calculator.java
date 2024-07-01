import java.util.Arrays;

public class Calculator {

    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiple(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int stringAdd(String input) {
        String customSeparator = "";
        String[] expressions = {};

        if (input.startsWith("//")) {
            expressions = input.split("\n");
            customSeparator = expressions[0].substring(2);
        }
        String[] expression = expressions[1].split("[,|:|" + customSeparator + "]");

        int result = 0;
        for (String a : expression) {
            try {
                int num = Integer.parseInt(a);
                if (num < 0) {
                    throw new RuntimeException();
                }
                result += num;
            } catch (Exception e) {
                throw new RuntimeException("잘못된 문자열입니다.");
            }
        }

        return result;
    }
}
