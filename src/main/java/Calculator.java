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
        if (input.isBlank()) {
            throw new RuntimeException();
        }

        String customSeparator = "";
        if (input.startsWith("//")) {
            String[] expressions = input.split("\n");
            customSeparator = expressions[0].substring(2);
            input = expressions[1];
        }
        String[] strList = input.split("[,:" + customSeparator + "]");

        int result = 0;
        for (String str : strList) {
            try {
                int num = Integer.parseInt(str);
                if (num < 0) {
                    throw new RuntimeException();
                }
                result += num;
            } catch (Exception e) {
                throw new RuntimeException("잘못된 문자열입니다. string: " + str);
            }
        }

        return result;
    }
}
