public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int parseAndSum(String input) {

        if (input == null) {
            throw new RuntimeException("Input cannot be null");
        }

        String customSeparator = "";
        if (input.startsWith("//")) {
            String[] split = input.split("\n");
            customSeparator = split[0].substring(2);
            input = split[1];
        }

        String regex = "[,:" + customSeparator + "]";
        String[] numbers = input.split(regex);

        int sum = 0;
        for (String number : numbers) {
            try {
                int num = number.isBlank() ? 0 : Integer.parseInt(number);

                if (num < 0) {
                    throw new RuntimeException("음수는 입력 불가능");
                }

                sum += num;
            } catch (NumberFormatException e) {
                throw new RuntimeException("잘못된 문자열 형식 - input: " + input);
            }
        }

        return sum;
    }
}
