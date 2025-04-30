package view;

import java.util.Scanner;

public class inputView {

    private Scanner scanner = new Scanner(System.in);

    public String getString() {
        return scanner.nextLine();
    }
}
