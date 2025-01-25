public class Calculator {
    //Basic Calculator
    //인자 2개를 받아 정수 결과를 반환
    //사칙연산을 위한 메서드 4개르 제공

    public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public int mul(int a, int b){
        return a*b;
    }

    public int div(int a, int b){
        if(b == 0){
            throw new RuntimeException("0으로는 나눌 수 없습니다");
        }
        return a/b;
    }
}
