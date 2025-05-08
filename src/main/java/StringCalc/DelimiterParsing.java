package StringCalc;

import java.util.regex.Pattern;

public class DelimiterParsing {
    public static String extractDelimiter(String input){
        if (input.startsWith("//")) {
            return Pattern.quote(input.split("\n",2)[0].substring(2));
        }
        return "[,:]";
        }
        public static String extractNumbers(String input){
        if (input.startsWith("//")) {
            return input.split("\n", 2)[1];
        }
            return input;
    }
}
