package view;

import java.util.Scanner;

public class inputView {

    private Scanner input_string = new Scanner(System.in);

    public String getString() {
        return input_string.nextLine();
    }
}
