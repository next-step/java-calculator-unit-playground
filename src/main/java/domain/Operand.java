package domain;

public class Operand {
    private final int operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public Operand(String operand) {
        try {
            this.operand = Integer.parseInt(operand);
            if(this.operand < 0){
                throw new RuntimeException("음수는 계산할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수로 변환할 수 없는 문자열입니다: " + operand);
        }
    }

    public int getValue(){
        return this.operand;
    }
}
