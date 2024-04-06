public class Calculator {
    public Integer add(int x, int y) {
        return x + y;
    }

    public Integer subtract(int x, int y) {
        return x - y;
    }

    public Integer multiply(int x, int y) {
        return x * y;
    }

    public double divide(int x, int y) {
        if(y == 0) {
            throw new ArithmeticException("Zero is not divided");
        }
        return (double) x / y;
    }
}
