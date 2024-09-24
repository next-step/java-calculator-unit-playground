package StringCalculator.domain;

import java.util.ArrayList;
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
        if(customExist()) operations = List.of(input.split(format("[%s|%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR, CUSTOM_SEPARATOR)));
        else operations = List.of(input.split(format("[%s|%s]", FIRST_SEPARATOR, SECOND_SEPARATOR)));
    }

    private static boolean customExist() {
        return CUSTOM_SEPARATOR != "";
    }

}
