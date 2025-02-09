package util;

public class CalculatorUtil {

    public CalculatorUtil() {
    }

    public static boolean isIntegerString(String string) {
        if (string.isEmpty()) {
            return false;
        }

        for (char word : string.toCharArray()) {
            if (!Character.isDigit(word)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isContainsDigit(String string) {
        if (string.isEmpty()) {
            return false;
        }

        for (char word : string.toCharArray()) {
            if (Character.isDigit(word)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static boolean isNotNegative(int number) {
        return number >= 0;
    }

    public static boolean isZero(int number) {
        return number == 0;
    }

    public static boolean isFloatNumber(String stringNumber) {
        return stringNumber.contains(".");
    }

    public static String addEscape(char word) {
        return "\\" + word;
    }
}
