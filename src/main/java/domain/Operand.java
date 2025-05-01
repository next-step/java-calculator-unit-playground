package domain;

public class Operand {
    private final int operand;

    public Operand(double operand) {
        this.operand = (int) operand;
    }

    public Operand(int operand) {
        this.operand = operand;
    }

    public Operand(String operand) {
        try {
            double parsed = Double.parseDouble(operand);
            this.operand = (int) parsed;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다: " + operand);
        }
    }

    public int getValue(){
        return this.operand;
    }
}
