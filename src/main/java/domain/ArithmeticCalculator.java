package domain;

public class ArithmeticCalculator {

    private static final int INITIAL_NUMBER = 0;
    private static final int MULTIPLE_DIVIDE_NUMBER = 1;
    private int[] intArr;
    private int result = INITIAL_NUMBER;

    public int getResult() {
        return result;
    }

    public int plusCalculate(String str) {
        resetArr(str);
        for (int i = INITIAL_NUMBER; i < intArr.length; i++) {
            result += intArr[i];
        }
        return result;
    }

    public int minusCalculate(String str) {
        resetArr(str);
        for (int i = INITIAL_NUMBER; i < intArr.length; i++) {
            result -= intArr[i];
        }
        return result;
    }

    public int divideCalculate(String str) {
        resetArr(str);
        result = intArr[0];
        for (int i = MULTIPLE_DIVIDE_NUMBER; i < intArr.length; i++) {
            result /= intArr[i];
        }
        return result;
    }

    public int multipleCaculate(String str) {
        resetArr(str);
        for (int i = INITIAL_NUMBER; i < intArr.length; i++) {
            result = MULTIPLE_DIVIDE_NUMBER;
            result *= intArr[i];
        }
        return result;
    }

    private void resetArr(String strArr) {
        intArr = new int[strArr.length()];
    }
}
