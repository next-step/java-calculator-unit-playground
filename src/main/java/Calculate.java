public class Calculate {

    private final StringCalculate stringCalculate = new StringCalculate();

    public long add(long a,long b) {
        return a + b;
    }

    public long subtract(long a, long b) {
        return a - b;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    public long divide(long a, long b) {
        if(b == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return a / b;
    }

    public int calculateFromString(String input) {
        return stringCalculate.sum(input);
    }
}
