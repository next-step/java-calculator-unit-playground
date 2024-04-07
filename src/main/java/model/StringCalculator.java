package model;

public class StringCalculator {

    private int result = 0;

    public void plus(int value) {
        result += value;
    }

    public int getResult() {
        return result;
    }

    public void resetResult() {
        this.result = 0;
    }
}
