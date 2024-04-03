import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputToNumberProvider {

    private final Pattern pattern = Pattern.compile("//(.+?)\\n");
    private Matcher matcher;

    private String extractHeader() {
        return matcher.group(1);
    }

    private String extractContent() {
        return matcher.replaceAll("");
    }

    private String getPatternToHeader(String header) {
        char[] splitChars = header.toCharArray();
        StringBuilder pattern = new StringBuilder();
        pattern.append("[,|:");
        for(char splitChar: splitChars) pattern.append('|').append(splitChar);
        pattern.append("]");
        return pattern.toString();
    }

    private int pareseInt(String element) {
        int number = Integer.parseInt(element);
        if(number < 0) throw new IllegalArgumentException("음수는 입력 불가능합니다.");
        return number;
    }

    public int[] getNumbers(String input) {
        matcher = pattern.matcher(input);
        matcher.find();

        String header = extractHeader();
        String content = extractContent();
        String splitPattern = getPatternToHeader(header);
        String[] splitContents = content.split(splitPattern);

        return Arrays.stream(splitContents).mapToInt(this::pareseInt).toArray();
    }
}
