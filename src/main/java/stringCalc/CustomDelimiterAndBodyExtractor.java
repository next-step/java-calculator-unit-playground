package stringCalc;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterAndBodyExtractor {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static DelimeterAndBodyInfo extract(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            String body = matcher.group(2);
            return new DelimeterAndBodyInfo(customDelimiter, body);
        }
        return new DelimeterAndBodyInfo("",input);
    }

    public static class DelimeterAndBodyInfo {

        public String BASIC_DELIMITER_COMMA = ",";
        public String BASIC_DELIMITER_COLON = ":";
        private String customDelimiter;
        private String body;

        public DelimeterAndBodyInfo(String delimiter, String body) {
            this.customDelimiter = delimiter;
            this.body = body;
        }

        public String getDelimiter(){
            return customDelimiter;
        }

        public String getBody(){
            return body;
        }
    }
}
