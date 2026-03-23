package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private int customSeparatorEndIndex;

    // 각 과정을 순차적으로 실행
    public int calculateSumOfString(String input) {
        StringBuilder separators = getSeparators(input);
        Pattern pattern = generatePatternFromSeparators(separators);
        String[] splitNumbers = splitString(input, pattern);
        return sumStringArray(splitNumbers);
    }

    // 구분자 문자열 생성
    private StringBuilder getSeparators(String input) {
        // default separators
        StringBuilder separators = new StringBuilder(",:");

        // custom separators
        customSeparatorEndIndex = -1;
        if (input.startsWith("//")) {
            customSeparatorEndIndex = input.indexOf("\n");
            if (customSeparatorEndIndex == -1) {
                throw new RuntimeException("Missing '\\n' after custom separators");
            }
            for (int i = 2; i < customSeparatorEndIndex; i++) {
                separators.append(input.charAt(i));
            }
        }

        return separators;
    }

    // 구분자 문자열로부터 Pattern 생성
    private Pattern generatePatternFromSeparators(StringBuilder separators) {
        // 구분자 중 대괄호가 있다면 이스케이프 (정규표현식 오류 방지)
        int leftBracketIndex = separators.indexOf("[");
        if (leftBracketIndex != -1) {
            separators.insert(leftBracketIndex, "\\");
        }
        int rightBracketIndex = separators.indexOf("]");
        if (rightBracketIndex != -1) {
            separators.insert(rightBracketIndex, "\\");
        }

        // Pattern 생성 및 반환
        return Pattern.compile("[" + separators + "]");
    }

    // Pattern에 따라 문자열을 분할하고 숫자 총합 구하기
    private String[] splitString(String input, Pattern pattern) {
        // custom separator 지정 부분 잘라내기
        String numString = input.substring(customSeparatorEndIndex + 1);

        // 정규표현식 기준으로 나누고 반환
        return pattern.split(numString);
    }

    private int sumStringArray(String[] splitNumbers) {
        // 분할된 숫자 총합 구하기
        int sum = 0;
        for (String strNum: splitNumbers) {
            try{
                int num = Integer.parseInt(strNum);
                if (num < 0) {
                    throw new RuntimeException("Do not input negative numbers");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Please input only numbers and separators");
            }
        }

        return sum;
    }
}
