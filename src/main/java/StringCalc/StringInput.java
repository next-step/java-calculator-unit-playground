package StringCalc;

import java.util.Scanner;

public class StringInput {
    private final String expression;

    public StringInput() {
        Scanner sc = new Scanner(System.in);
        this.expression = sc.nextLine();
    }

    public String getExpression() {
        return expression;
    }
}