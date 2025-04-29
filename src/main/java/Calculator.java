import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final TokenSplitter tokenSplitter;

    public Calculator() {
        this.tokenSplitter = new TokenSplitter();
    }

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = tokenSplitter.getToken(input);
        List<Integer> numbers = getNumbers(tokens);

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private List<Integer> getNumbers(final String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .toList();
    }
}
