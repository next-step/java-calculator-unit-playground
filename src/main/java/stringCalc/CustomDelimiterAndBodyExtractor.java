package stringCalc;
import java.util.ArrayList;
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

        private String BASIC_DELIMITER_COMMA = ",";
        private String BASIC_DELIMITER_COLON = ":";
        private ArrayList<String> delimiter;
        private String body;

        public DelimeterAndBodyInfo(String delimiter, String body) {

            this.delimiter.add(BASIC_DELIMITER_COLON);
            this.delimiter.add(BASIC_DELIMITER_COMMA);
            this.delimiter.add(delimiter);
            this.body = body;

        }

        public ArrayList<String> getDelimiter(){
            return delimiter;
        }

        public String getBody(){
            return body;
        }
    }
}
