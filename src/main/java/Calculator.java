public class Calculator {

    public int add(int a, int b) {

        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new ArithmeticException("덧셈 오버플로우 발생");
        }

        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("덧셈 언더플로우 발생");
        }

        return a + b;
    }

    public int subtract(int a, int b) {
      
        if (a > 0 && b < 0 && a > Integer.MAX_VALUE + b) {
            throw new ArithmeticException("뺄셈 오버플로우 발생");
        }

        if (a < 0 && b > 0 && a < Integer.MIN_VALUE + b) {
            throw new ArithmeticException("뺄셈 언더플로우 발생");
        }
      
        return a - b;
    }

    public int multiply(int a, int b) {

        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
            throw new ArithmeticException("곱셈 오버플로우 발생");
        }

        return a * b;
    }

    public int divide(int a, int b) {
      
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 경우 강제로 예외처리");
        }

        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("나눗셈 오버플로우 발생");
          
        }

        return a / b;
    }
}
