package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

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
}
