package calculator.view;

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
        return scanner.next().charAt(0);
    }
}
