package StringCalculator.domain;

import java.util.List;

import static StringCalculator.util.Config.*;
import static java.lang.String.format;

public class StringCalculator {
    private static List<String> operations;

    public static int stringCalculate(String input) {
        parsing(input);

        return operations.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static void parsing(String input) {
        settingCustomSeparator(input);

        if(customExist()) {
            input = input.substring(FIRST_CUSTOM_SETTING_STRING.length()
                    + CUSTOM_SEPARATOR.length() + SECOND_CUSTOM_SETTING_STRING.length());
            operations = List.of(input.split(format("[%s|%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR, CUSTOM_SEPARATOR)));
        }
        else operations = List.of(input.split(format("[%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR)));
    }

    private static void settingCustomSeparator(String input) {
        if(input.startsWith(FIRST_CUSTOM_SETTING_STRING)) {
            input = input.substring(FIRST_CUSTOM_SETTING_STRING.length());

            int index = input.indexOf(SECOND_CUSTOM_SETTING_STRING);

            if(index != -1) {
                String result = input.substring(0, index);

                if(result != "") CUSTOM_SEPARATOR = result;
            }

        }
    }

    private static boolean customExist() {
        return CUSTOM_SEPARATOR != "";
    }

}
