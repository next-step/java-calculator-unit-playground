package domain;

public class Calculator {
    private static int result;

    void add(int a, int b){
        result=a+b;
    }

    void subtract(int a, int b){
        result=a-b;
    }

    void multiply(int a, int b){
        result=a*b;
    }

    void divide(int a, int b){
        result=a/b;
    }

}
