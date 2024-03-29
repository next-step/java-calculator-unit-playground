package org.duckstudy.calculator.util;

public class StringUtil {
    public static boolean isNumberic(String value) {
        return value.matches("[+]?\\d+");
    }
}
