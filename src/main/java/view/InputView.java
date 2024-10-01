package view;

import java.util.Scanner;

public class InputView {
    // 공용 Scanner
    private static Scanner scanner = new Scanner(System.in);

    // Normal Calculator
    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static int InputOperation() {
        return scanner.nextInt();
    }

    public static char InputOperator() {
        char operator = scanner.next().charAt(0);
        validateValidOperator(operator);

        return operator;
    }

    private static void validateValidOperator(char op) {
        if(!isOperators(op)) throw new IllegalArgumentException("Invalid operator");
    }

    private static boolean isOperators(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }


    // String Calculator
    public static String InputExpression() {
        return scanner.nextLine();
    }
}
