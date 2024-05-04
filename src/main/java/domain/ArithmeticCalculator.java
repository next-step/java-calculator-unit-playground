package domain;

public class ArithmeticCalculator {

    private static int i;
    private static int result;
    private static final int INITIAL_NUMBER = 0;
    private static final int ARRAY_RESET = 100;

    SplitString arr = new SplitString();

    public void plusCalculate() {
        result = INITIAL_NUMBER;
        arr.intArr = new int[ARRAY_RESET];
        for (i = INITIAL_NUMBER; i < arr.intArr.length; i++) {
            result += arr.intArr[i];
        }
    }

    void minusCalculate() {
        result = INITIAL_NUMBER;
        arr.intArr = new int[ARRAY_RESET];
        for (i = INITIAL_NUMBER; i < arr.intArr.length; i++) {
            result -= arr.intArr[i];
        }
    }

    void divideCalculate() {
        result = INITIAL_NUMBER;
        arr.intArr = new int[ARRAY_RESET];
        for (i = INITIAL_NUMBER; i < arr.intArr.length; i++) {
            result += arr.intArr[i];
        }
    }

    void multipleCaculate() {
        result = INITIAL_NUMBER;
        arr.intArr = new int[ARRAY_RESET];
        for (i = INITIAL_NUMBER; i < arr.intArr.length; i++) {
            result *= arr.intArr[i];
        }
    }
}
