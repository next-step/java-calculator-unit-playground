package view;

import java.util.Scanner;

public class InputView {

    private Scanner input = new Scanner(System.in);

    public String inputString() {
        while (input.hasNextLine()) {
            return input.nextLine();
        }
        return null;
    }
}
