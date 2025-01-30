public class Calculator {
    //Basic Calculator
    //인자 2개를 받아 정수 결과를 반환
    //사칙연산을 위한 메서드 4개를 제공

    public int add(int left, int right){
        return left+right;
    }

    public int sub(int left, int right){
        return left-right;
    }

    public int mul(int left, int right){
        return left*right;
    }

    public int div(int left, int right){
        if(right == 0){ //우변이 0인 경우 -> 0으로 나누는 문제
            throw new RuntimeException("0으로는 나눌 수 없습니다");
        }
        return left/right;
    }
}
