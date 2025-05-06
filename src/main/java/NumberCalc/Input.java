package NumberCalc;

import java.util.Scanner;

public class Input {
    private final Scanner sc;

    public Input(Scanner sc) {
        this.sc = sc;
    }

    public int readFirstNumber() {
        return sc.nextInt();
    }

    public int readSecondNumber() {
        return sc.nextInt();
    }
}
