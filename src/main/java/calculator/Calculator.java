package calculator;

public class Calculator{
    int add(int addend, int addend2){
        return addend + addend2;
    }
    int subtract(int minuend, int subtrahend){
        return minuend - subtrahend;
    }
    int multiply(int multiplicand, int multiplier){
        return multiplicand * multiplier;
    }
    int divide(int dividend, int divisor){
        if (divisor == 0){
            throw new ArithmeticException();
        }
        return dividend / divisor;
    }
}
