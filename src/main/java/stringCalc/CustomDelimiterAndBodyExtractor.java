package stringCalc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterAndBodyExtractor {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static ExtractedDelimiterAndBody extract(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            String body = matcher.group(2);
            return new ExtractedDelimiterAndBody(customDelimiter, body);
        }
        return new ExtractedDelimiterAndBody("",input);
    }


}
