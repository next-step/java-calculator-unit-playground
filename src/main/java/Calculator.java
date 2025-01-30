public class Calculator {

    public int add(int fir, int sec) {
        return fir + sec;
    }

    public int subtract(int fir, int sec) {
        return fir - sec;
    }

    public int multiply(int fir, int sec) {
        return fir * sec;
    }

    public int divide(int fir, int sec) {
        if (sec == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return fir / sec;
    }


}
