import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final String CUSTOM_DELIMITER = "([//])(.)([\n])";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final String EXCEPTION_NEGATIVE = "음수는 입력할 수 없습니다.";
    private static final String EXCEPTION_INCORRECT = "숫자만 입력할 수 있습니다.";


    private String findDelimiter(String input) {

        String delimiter = DEFAULT_DELIMITER;
        final Matcher findCustomDelimiter = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (findCustomDelimiter.find()){
            delimiter = findCustomDelimiter.group(2);

            return delimiter;
        }

        return delimiter;

    }

    private String[] parseInput(String input, String delimiter) {
        int startCalculateIndex = input.indexOf("\n")+1;
        input = input.substring(startCalculateIndex);

        String[] inputToToken = input.split(delimiter);

        return inputToToken;

    }

    private List<Integer> makeNumberList(String[] inputToToken) {
        List<Integer> numberList = new ArrayList<>();

        try {
            for (String token  : inputToToken) {
                int calculateNumber = Integer.parseInt(token);

                if (calculateNumber < 0 ) {
                    throw new RuntimeException(EXCEPTION_NEGATIVE);
                }
                numberList.add(calculateNumber);
            }
        } catch (NumberFormatException e ) {
            throw new RuntimeException(EXCEPTION_INCORRECT);
        }

        return numberList;

    }

    private int addNumbers(List<Integer> numberList) {

        int sum = 0;

        for (int number : numberList) {
            sum += number;
        }

        return sum;

    }

    public int separateResult(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        return addNumbers(makeNumberList(parseInput(input,findDelimiter(input))));

    }
}
