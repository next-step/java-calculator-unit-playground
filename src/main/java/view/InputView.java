package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String calculatorInput() {
        System.out.println("구분자를 넣어 계산할 문자열을 넣으시오:");
        return scanner.nextLine();
    }
}
