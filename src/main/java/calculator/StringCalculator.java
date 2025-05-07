package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    public int add(String input){
        int sum=0;
        if(input==null || input.isEmpty()){
            return 0;
        }
        String delimiters = DEFAULT_DELIMITERS;

        if(isCustomDelimiter(input)){
            int idx=input.indexOf("\n");
            String customDelimiter=input.substring(2,idx);
            delimiters = Pattern.quote(customDelimiter) + "|" + delimiters;
            input=input.substring(idx+1);
        }

        String[] tokens=input.split(delimiters);

        for(String token:tokens){
            // 숫자 이외 혹은 빈 토큰 검사
            if (!token.matches("-?\\d+")) {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException("Negative number: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
