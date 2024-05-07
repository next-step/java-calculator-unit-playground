package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<Integer> getNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("두 정수를 입력하세요. (입력 순서대로 계산, 쉼표(,)로 구분)");
        String inputNumber = input.next();
        String[] inputNumberList = inputNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String intList : inputNumberList){
            numbers.add(Integer.parseInt(intList));
        }
        return numbers;
    }
}
