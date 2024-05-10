package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner input = new Scanner(System.in);

    public String getString() {
        return input.next();
    }
}
