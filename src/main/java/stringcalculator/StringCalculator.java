package stringcalculator;
import java.util.Scanner;
import java.util.Arrays;

public class StringCalculator {

    public int delimiters(String input){
        //입력값이 없으면 예외를 발생
        if (input==null || input.isEmpty()){
            throw new IllegalArgumentException("값이 없거나 0이면 안된다.");
        }
        //구분자 문자열 변수
        String delimiter =",|:";
        //커스텀 구분자 처리
        if (input.startsWith("//")){
            int delimiterIndex= input.indexOf("\n");
            String CustomDelimiter = input.substring(2,delimiterIndex);
            if(CustomDelimiter.contains(",")|| CustomDelimiter.contains(":")){
                throw new IllegalArgumentException("기본 구분자가 포함되어있다.");
            }
            else {
                delimiter = delimiter+"|"+CustomDelimiter;
                input = input.substring(delimiterIndex +1);
            }
        }

        String[] tokens = input.split(delimiter);
        return calculateSum(tokens);
    }

    private int calculateSum(String[] tokens){
        int sum = 0;
        for (String token : tokens){
            int parsedNumber = parseNuber(token);
            if (parsedNumber < 0){
                throw new RuntimeException("음수는 허용이 안된다.");
            }
            try {
                sum += parsedNumber;
            }
            catch (ArithmeticException e){
                System.out.println("오버플로우 발생.");

            }
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