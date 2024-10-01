import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueExtractor {
  public static String[] extractValueByString(String value) {
    StringBuilder divider = new StringBuilder("[,");

    Pattern dividerPattern = Pattern.compile("//(.*?)\n");
    Matcher matcher = dividerPattern.matcher(value);

    while(matcher.find()) {
      divider.append("|").append(matcher.group(1));
    }

    return value.replaceAll(dividerPattern.pattern(), "").split(divider.append("]").toString());
  }
}
