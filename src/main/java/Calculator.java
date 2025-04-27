/**
 * 기능 요구사항
 * -인자 2개를 받아 사칙연산을 할 수 있는 계산기를 구현한다
 * -사칙연산과 매칭되는 4개의 메서드를 제공한다.
 * -계산된 결과는 정수를 반환한다.
 */
public class Calculator {

    int add(int num1, int num2) {
        return num1 + num2;
    }

    int subtract(int num1, int num2) {
        return num1 - num2;
    }

    int multiply(int num1, int num2) {
        return num1 * num2;
    }

    int divide(int num1, int num2) {
        return num1 / num2;
    }

}
