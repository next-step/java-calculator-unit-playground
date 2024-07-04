import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomStringExtractor {

    private final Pattern expression = Pattern.compile("//(.+?)\\n(.*)");

    public String[] extractString(String input) {
        Matcher matcher = expression.matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(String.format("[,|:|%s]", matcher.group(1)));
        }
        return input.split("[,|:]");
    }
}
