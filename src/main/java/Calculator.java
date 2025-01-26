import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        //여기서부터 프로그램 시작
        System.out.println("[전서영] 1주차 계산기 구현 과제");
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 숫자 입력받기
        System.out.println("Please enter the numbers. : ");
        String expression = scanner.nextLine();

        // 쉼표와 콜론으로 숫자들 분리
        String[] tokens = expression.split("[,|:]");

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        System.out.println("Results: " + sum);

        scanner.close();
    }
}