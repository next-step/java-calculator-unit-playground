package simpleCalculator.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getSimpleNumber() {
        System.out.println("계산할 내용을 입력해주세요.(숫자,연산자,숫자 형식)");
        while (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    public String getStringNumber() {
        System.out.println("기본(, :)이나 커스텀 구분자(;)를 가지는 문자열을 입력해주세요. (예: 1,2 => 3, //;\\n1;2;3 => 6 반환)");
        while (scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }
}