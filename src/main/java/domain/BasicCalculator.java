package domain;

public class BasicCalculator {

    public static int addNum(int num1, int num2){
        return num1+num2;
    }

    public static int subtractNum(int num1, int num2){
        return num1-num2;
    }

    public static int multiplyNum(int num1, int num2){
        return num1*num2;
    }

    public static int divideNum(int num1, int num2){
        if (num2==0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1/num2;
    }
}
