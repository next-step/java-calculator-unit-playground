package util;

import exception.ErrorMessage;

public class DelimiterUtil {

    public static String findCustomDelimiter(String str) {
        int startDelimiterIdx = str.indexOf("//");
        int endDelimiterIdx = str.indexOf("\n");

        if (startDelimiterIdx == -1 && endDelimiterIdx == -1) {
            return null;
        }

        if ((startDelimiterIdx == -1) ^ (endDelimiterIdx == -1) || (startDelimiterIdx + 2 == endDelimiterIdx)) {
            throw new RuntimeException(ErrorMessage.CUSTOM_DELIMITER_NOT_FOUND);
        }

        return str.substring(startDelimiterIdx + 2, endDelimiterIdx);
    }
}
