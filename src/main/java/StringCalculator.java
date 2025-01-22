/*
input을 받고 빈문자열인지 null인지 체크
구분자 체크 -> 구분자 예외 체크
구분자 대로 문자열 계산기 구현
 */

import java.util.regex.Pattern;

public class StringCalculator {

    //입력 문자열이 null인지 확인
    public String checkInput(String input){
        if(input == null) throw new RuntimeException("null은 허용되지 않습니다.");
        return input;
    }

    //커스텀 구분자가 있는지 확인 후 구분자대로 문자열 나누기
    public String[] checkDelimiter(String input) {
        String checkedInput = checkInput(input);
        if(checkedInput.isEmpty()) return new String[0]; //문자열이 빈 경우

        String delimiter = "[,:]";

        if (checkedInput.startsWith("//")) { //커스텀 구분자를 설정하는가?
            int idx = checkedInput.indexOf("\n"); //제대로된 형식인가?
            if (idx == -1) throw new RuntimeException("잘못된 커스텀 구분자 형식입니다.");

            delimiter = checkedInput.substring(2, idx); //구분자 나누기
            String regex = Pattern.quote(delimiter); //정규표현식에 사용되는 문자가 커스텀 구분자일 경우를 위해 설정
            return checkedInput.substring(idx + 1).split(regex); //커스텀 구분자대로 문자열을 나눔
        }
        return checkedInput.split(delimiter); //기본 구분자대로 문자열을 나눔
    }

    //문자열 덧셈 실행
    public int sum(String input){
        String [] strings = checkDelimiter(input);
        if(strings.length == 0) return 0;
        int sum = 0;

        for(var n : strings){
            if(n.isEmpty()) throw new RuntimeException("빈 문자열입니다.");
            //예외 처리
            try{
                int num = Integer.parseInt(n);
                if(num < 0) throw new RuntimeException("음수는 입력이 불가합니다.");
                sum += num;
            }
            catch(NumberFormatException msg){
                throw new RuntimeException("잘못된 숫자 형식입니다.");
            }
        }
        return sum;
    }
}
