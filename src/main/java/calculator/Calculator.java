package calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int stringSum(String input) {
        String target = input;
        String customSeparator = "";
        if (target == null) {
            throw new RuntimeException("잘못된 문자열 형식입니다. input: " + input);
        }
        if (input.startsWith("//")) {
            String[] split = input.split("\n");
            customSeparator = split[0].substring(2);
            target = split[1];
        }
        String regex = "[\\:\\," + customSeparator + "]";
        String[] numbers = target.split(regex);

        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new RuntimeException("잘못된 문자열 형식입니다. input: " + input);
            }
        }
        return sum;
    }
}
