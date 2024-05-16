package view;

import java.util.Scanner;

public class InputView {

    public Scanner input = new Scanner(System.in);

    public String inputString() {
        while(input.hasNextLine()){
            return input.nextLine();
        }
        return null;
    }
}
