public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        long result = (long) num1 * num2;
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("오버플로우가 발생했습니다.");
        }
        return (int) result;
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return dividend / divisor;
    }
}
