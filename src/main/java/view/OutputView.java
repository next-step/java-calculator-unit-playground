package view;

import java.util.Scanner;

public class Outputview {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.getCalculator();
        System.out.println("계산 결과:");
        System.out.println(input);
    }
}
