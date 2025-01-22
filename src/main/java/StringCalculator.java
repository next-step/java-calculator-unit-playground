/*
input을 받고 빈문자열인지 null인지 체크
구분자 체크 -> 구분자 예외 체크
구분자 대로 문자열 계산기 구현
 */

import java.util.regex.Pattern;

public class StringCalculator {
    public String checkInput(String input){
        if(input == null) throw new RuntimeException("null은 허용되지 않습니다.");
        return input;
    }

    public String[] checkDelimiter(String input) {
        String checkedInput = checkInput(input);
        if(checkedInput.isEmpty()) return new String[0];
        String delimiter = "[,:]";
        if (checkedInput.startsWith("//")) {
            int idx = checkedInput.indexOf("\n");
            if (idx == -1) throw new RuntimeException("잘못된 커스텀 문자 형식입니다.");
            delimiter = checkedInput.substring(2, idx);
            String regex = Pattern.quote(delimiter);
            return checkedInput.substring(idx + 1).split(regex);
        }
        return checkedInput.split(delimiter);
    }

    public int sum(String input){
        String [] strings = checkDelimiter(input);
        if(strings.length == 0) return 0;
        int sum = 0;
        for(var n : strings){
            if(n.isEmpty()) throw new RuntimeException("빈 문자열입니다.");
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
