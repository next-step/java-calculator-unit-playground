package simpleCalculator.model;
public class Calculator {
    private final int num1;
    private final int num2;

    public Calculator(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public int addNumbers(){
        return num1 + num2;
    }

    public int subNumbers(){
        return num1 - num2;
    }

    public int divideNumbers(){
        return num1/num2;
    }

    public int multipleNumbers(){
        return num1 * num2;
    }
}