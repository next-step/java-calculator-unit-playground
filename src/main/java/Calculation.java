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
}
