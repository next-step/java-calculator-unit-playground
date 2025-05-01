package stringCalc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterAndBodyExtractor {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static DelimeterAndBodyInfo extract(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if(matcher.matches()){
            String customDelimiter = matcher.group(0);
            String body = matcher.group(1);
            return new DelimeterAndBodyInfo(customDelimiter, body);
        }
        return new DelimeterAndBodyInfo("",input);
    }

    public static class DelimeterAndBodyInfo {
        private String delimiter;
        private String body;

        public DelimeterAndBodyInfo(String delimiter, String body) {
            this.delimiter = delimiter;
            this.body = body;
        }

        public String getDelimiter(){
            return delimiter;
        }

        public String getBody(){
            return body;
        }
    }
}
