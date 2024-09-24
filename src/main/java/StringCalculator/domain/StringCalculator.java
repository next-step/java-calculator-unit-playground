package StringCalculator.domain;

import java.util.List;

import static StringCalculator.util.Config.*;
import static java.lang.Character.isDigit;
import static java.lang.String.format;

public class StringCalculator {
    private static List<String> operations;

    public static int stringCalculate(String input) {
        parsing(input);

        return operations.stream()
                .mapToInt(operations -> {
                    int value = Integer.parseInt(operations);

                    if (isNegative(value)) throw new RuntimeException("음수는 임력할 수 없습니다.");

                    return value;
                })
                .sum();
    }

    private static void parsing(String input) {
        if(isEmpty(input)) throw new RuntimeException("공백은 입력할 수 없습니다.");

        settingCustomSeparator(input);

        if(customExist()) {
            input = input.substring(FIRST_CUSTOM_SETTING_STRING.length()
                    + CUSTOM_SEPARATOR.length() + SECOND_CUSTOM_SETTING_STRING.length());

            if(!isValidSeparator(input)) throw new RuntimeException("지정된 구분자 이외에는 다른 구분자를 사용할 수 없습니다.");

            operations = List.of(input.split(format("[%s|%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR, CUSTOM_SEPARATOR)));
        }
        else {

            if(!isStartedWithDigit(input)) throw new RuntimeException("커스텀 구분자 지정 외에는 숫자로 시작해야 합니다.");
            if(!isValidSeparator(input)) throw new RuntimeException("지정된 구분자 이외에는 다른 구분자를 사용할 수 없습니다.");

            operations = List.of(input.split(format("[%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR)));
        }
    }

    private static void settingCustomSeparator(String input) {
        if(input.startsWith(FIRST_CUSTOM_SETTING_STRING)) {
            input = input.substring(FIRST_CUSTOM_SETTING_STRING.length());

            int index = input.indexOf(SECOND_CUSTOM_SETTING_STRING);

            if(index != -1) {
                String result = input.substring(0, index);

                if(!result.isEmpty()) CUSTOM_SEPARATOR = result;
            }

        }
    }

    private static boolean isStartedWithDigit(String input) {
        return isDigit(input.charAt(0));
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }


    private static boolean isValidSeparator(String input) {
        if (CUSTOM_SEPARATOR.isEmpty()) {
            return input.chars().anyMatch(c -> !Character.isDigit(c) && !String.valueOf(c).equals(FIRST_SEPARATOR) && !String.valueOf(c).equals(SECOND_SEPARATOR));
        }

        return input.chars().anyMatch(c -> !Character.isDigit(c) && !String.valueOf(c).equals(FIRST_SEPARATOR) && !String.valueOf(c).equals(SECOND_SEPARATOR) && !String.valueOf(c).equals(CUSTOM_SEPARATOR));
    }

    private static boolean customExist() {
        return !CUSTOM_SEPARATOR.isEmpty();
    }

}
