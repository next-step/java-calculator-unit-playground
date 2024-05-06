package domain;

public class Calculator {
    private static int result;

    public int add(int a, int b){
        result=a+b;
        return result;
    }

    public int subtract(int a, int b){
        result=a-b;
        return result;
    }

    public int multiply(int a, int b){
        result=a*b;
        return result;
    }

    public int divide(int a, int b){
        result=a/b;
        return result;
    }

}
