import java.util.function.BiFunction;

public class Calculator {
    public static int calculate(BiFunction<Integer, Integer, Integer> func, int num1, int num2) {
        try {
            return func.apply(num1, num2);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("연산 결과가 자료형 int의 범위를 벗어났습니다.");
        }
    }

    public static int add(int num1, int num2) {
        return calculate(Math::addExact, num1, num2);
    }

    public static int sub(int num1, int num2) {
        return calculate(Math::subtractExact, num1, num2);
    }

    public static int mul(int num1, int num2) {
        return calculate(Math::multiplyExact, num1, num2);
    }

    public static int div(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return num1 / num2;
    }
}