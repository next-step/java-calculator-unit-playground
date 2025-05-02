package NumberCalc;

public class Calculator {

    public int add (int n1, int n2){
        return n1 + n2;
    }

    public int subtract (int n1, int n2) {
        return n1 - n2;
    }

    public int multiply (int n1, int n2) {
        return n1 * n2;
    }

    public int divide (int n1, int n2){
        if (n2 == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return n1 / n2;
    }
}