package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_MARKER = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    //파싱된 결과를 저장
    private static class ParseResult {
        private final String targetString;
        private final String separator;

        public ParseResult(String targetString, String separator) {
            this.targetString = targetString;
            this.separator = separator;
        }

        public String getTargetString() {
            return targetString;
        }

        public String getSeparator() {
            return separator;
        }
    }

    //입력된 문자열에서 구분자, 문자열 추출 
    private ParseResult parse(String inputString) {
        //커스텀 구분자를 사용하는 경우
        if(inputString.startsWith(CUSTOM_SEPARATOR_MARKER)) {
            int newLineIdx = inputString.indexOf(CUSTOM_SEPARATOR_END);
        
            String separator = Pattern.quote(inputString.substring(2, newLineIdx));
            String targetString = inputString.substring(newLineIdx + 1);

            return new ParseResult(targetString, separator);
        }

        //기본 구분자를 사용하는 경우 
        return new ParseResult(inputString, DEFAULT_SEPARATOR);
    }

    //입력값 검증(숫자가 아닌 값이 포함된 경우, 음수가 포함된 경우), int 추출 
    private int validateInputAndParseToInt(String token) {

        try {
                int parsedNumber = Integer.parseInt(token.trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자 이외의 값 " + token + "이 들어있습니다!");
            }            

            if(parsedNumber < 0) {
                throw new IllegalArgumentException("음수값은 입력할 수 없습니다.");
            } 

            return parsedNumber;
    }

    private int calculateSum(String targetString, String separator) {
        int sum = 0;

        for(String token: targetString.split(separator)) {
            sum += validateInputAndParseToInt(token);
        }

        return sum; 
    }

        
    //메인로직 
    public int sumFromString(String inputString) {
        if(inputString == null || inputString.isBlank()) { 
            return 0;
        }

        ParseResult result = parse(inputString);

        return calculateSum(result.getTargetString(), result.getSeparator());
    }

    //---------------------------------------------------------------------------
    //정수 사칙연산 
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int subtract(int n1, int n2) {
        return n1 - n2;
    }

    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    public int division(int n1, int n2) {
        return n1 / n2;
    }

}
