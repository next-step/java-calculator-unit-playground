package NumberCalc;

import java.util.Scanner;

//public class Input {
//    private final Scanner sc;
//
//    public Input(Scanner sc) {
//        this.sc = sc;
//    }
//
//    public int readFirstNumber() {
//        return sc.nextInt();
//    }
//
//    public int readSecondNumber() {
//        return sc.nextInt();
//    }
//}

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    private Input() {} // Input의 인스턴스가 필요 없으므로 인스턴스가 생성되지 않도록 방지

    public static int readFirstNumber() {
        return sc.nextInt();
    }

    public int readSecondNumber() {
        return sc.nextInt();
    }
}

