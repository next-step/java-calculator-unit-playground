import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
}