import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = getTokens(input);
        List<Integer> numbers = getNumbers(tokens);

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private String[] getTokens(final String input) {
        return input.split("[,|:]");
    }

    private List<Integer> getNumbers(final String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .toList();
    }
}
