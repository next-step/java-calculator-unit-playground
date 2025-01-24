package stringcalculator;
import java.util.Scanner;
import java.util.Arrays;

public class StringCalculator {

    public int add(String input){
        //입력값이 없으면 0반환
        if (input==null || input.isEmpty()){
            return 0;
        }
        //구분자 문자열 변수
        String delimiter =",|:";
        //커스텀 구분자 처리
        if (input.startsWith("//")){
            int delimiterIndex= input.indexOf("\n");
            delimiter = input.substring(2,delimiterIndex);
            input = input.substring(delimiterIndex +1);
        }

        String[] tokens = input.split(delimiter);
        return calculateSum(tokens);
    }

    private int calculateSum(String[] tokens){
        int sum = 0;
        for (String token : tokens){
            int parsedNumber = parseNuber(token);
            if (parsedNumber <0){
                throw new RuntimeException("음수는 허용이 안된다.");
            }
            sum += parsedNumber;
        }
        return sum;
    }

    private int parseNuber(String token){
        try{
            return Integer.parseInt(token);
        } catch (NumberFormatException e){
            throw new RuntimeException("숫자를 입력해주세요.");
        }
    }
}