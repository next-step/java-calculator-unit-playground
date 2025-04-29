import java.util.List;

public class Calculator {

    private final TokenSplitter tokenSplitter;
    private final StringConverter stringConverter;

    public Calculator() {
        this.tokenSplitter = new TokenSplitter();
        this.stringConverter = new StringConverter();
    }

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = tokenSplitter.tokenize(input);
        List<Integer> numbers = stringConverter.convertAndValidateNumbers(tokens);

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
