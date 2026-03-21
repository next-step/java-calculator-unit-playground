package calculator;

public class Calculator {
    int add(int num1, int num2) {
        return num1 + num2;
    }

    int subtract(int num1, int num2) {
        return num1 - num2;
    }

    int multiply(int num1, int num2) {
        return num1 * num2;
    }

    int divide(int num1, int num2) {
        return num1 / num2;
    }

    int stringAdd(String expression) {

        if (expression.equals("")) {
            return 0;
        }


        if (expression.matches("//.\n.*")) {
            String delimiter = expression.split("//|\n")[1];
            String withoutDelimiter = expression.split("\n")[1];
            String[] tokens = withoutDelimiter.split(delimiter);

            int sum = 0;
            for (String token : tokens) {
                if (token.matches("\\d")) {
                    sum += Integer.parseInt(token);
                } else {
                    throw new RuntimeException();
                }
            }
            return sum;
        } else {
            String[] tokens = expression.split("[,:]", -1);
            int sum = 0;
            for (String token : tokens) {
                if (token.matches("\\d")) {
                    sum += Integer.parseInt(token);
                } else {
                    throw new RuntimeException();
                }
            }

            return sum;
        }
    }
}
