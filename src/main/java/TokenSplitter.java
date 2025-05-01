import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenSplitter {

    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String DEFAULT_REGEX = "[,|:]";
    private static final Pattern CUSTOM_REGEX = Pattern.compile("(?<=//)(.+?)(?=\\\\n)");

    public List<String> tokenize(final String input) {
        if (input.startsWith(CUSTOM_PREFIX)) {
            validateCustomFormat(input);
            String preInput = preprocessInput(input);
            return List.of(preInput.split(findCustom(input)));
        }
        return List.of(input.split(DEFAULT_REGEX));
    }

    private void validateCustomFormat(final String input) {
        if (!input.contains(CUSTOM_SUFFIX)) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
    }

    private String preprocessInput(final String input) {
        return input.substring(input.indexOf(CUSTOM_SUFFIX) + CUSTOM_SUFFIX.length());
    }

    private String findCustom(final String input) {
        Matcher matcher = CUSTOM_REGEX.matcher(input);
        matcher.find();
        return Pattern.quote(matcher.group());
    }
}
