public class Calculator {
    public int add(int i, int j){
        return i + j;
    }

    public int subtract(int i, int j){
        return i - j;
    }

    public int multiply(int i, int j){
        return i * j;
    }

    public int divide(int i, int j){
        if (j == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return i / j;
    }
}
