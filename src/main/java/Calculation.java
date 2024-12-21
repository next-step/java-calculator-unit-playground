import java.math.BigDecimal;

public class Calculation {
    double plus(double a, double b) {
        return a + b;
    }

    double minus(double a, double b) {
        return a - b;
    }

    double multiplication(double a, double b) {
        BigDecimal c = BigDecimal.valueOf(a);
        BigDecimal d = BigDecimal.valueOf(b);
        return c.multiply(d).doubleValue();
    }

    double division(double a, double b) {
        return a / b;
    }

    double stringPlusCalc(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\n");
            if (endIndex == -1) {
                throw new RuntimeException("커스텀 구분자 등록이 실패했습니다.");
            }
            delimiter += "|" + input.substring(2, endIndex);
            input = input.substring(endIndex + 1);
        }

        String[] items = input.split(delimiter);
        double sum = 0;
        for (String item : items) {
            try {
                double number = Double.parseDouble(item.trim());
                sum += number;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자와 구분자만 입력하세요");
            }
        }

        return sum;
    }
}
