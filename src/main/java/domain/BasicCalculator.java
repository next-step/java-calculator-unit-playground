package domain;

public class BasicCalculator {

    private int num1;
    private int num2;

    public BasicCalculator(int num1, int num2){
        this.num1=num1;
        this.num2=num2;
    }

    public int addNum() {
        return num1 + num2;
    }

    public int subtractNum() {
        return num1 - num2;
    }

    public int multiplyNum() {
        return num1 * num2;
    }

    public int divideNum() {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
