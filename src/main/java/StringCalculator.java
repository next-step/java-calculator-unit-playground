import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {


    public int addAll(String input) {

        //빈 문자열 처리
        if(input == null || input.isEmpty()) return 0;

        //기본 구분자 정규표현식 (, 또는 :)
        String regex = "[,|:]";

        //커스텀 구분자를 사용하는 경우
        if (input.startsWith("//")) {
            //잘못된 구문에 대한 예외 처리
            int formatEndIndex = input.indexOf("\n");
            if (formatEndIndex == -1){ // "\n" 을 찾을 수 없는 경우
                throw new RuntimeException("올바르지 않은 커스텀 구분자 지정 구문입니다.");
            }

            regex = "[,|:|" + Pattern.quote(input.substring(2, formatEndIndex)) + "]"; //Pattern.quote를 이용하여 특수문자를 안전하게 처리
            input = input.substring(formatEndIndex+1); //커스텀 구분자 지정하는 부분을 제거

        }else if(input.contains("\n"))
        {
            // "\n"은 있지만 "//"으로 시작하지 않는 경우에 RuntimeException 던지기
            throw new RuntimeException("올바르지 않은 커스텀 구분자 지정 구문입니다.");
        }

        return calculateSum(input,regex);
    }

    private int calculateSum(String numbers, String regex) {
        String[] tokens = numbers.split(regex);

        List<Integer> parsedNumbers = new ArrayList<>();

        for(String token : tokens){
            try{
                int parsedNumber = Integer.parseInt(token);
                if(parsedNumber < 0){
                    throw new RuntimeException("음수가 입력되었습니다.");
                }

                parsedNumbers.add(parsedNumber);
            }catch (NumberFormatException e){
                throw new RuntimeException("숫자 이외의 값이 입력되었습니다.");
            }
        }

        //숫자를 모두 더해 반환
        int result = 0;
        for(int number : parsedNumbers){
            result += number;
        }
        return result;


    }

}
