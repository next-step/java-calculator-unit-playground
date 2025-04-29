import java.util.List;
import java.util.stream.Collectors;

public class NumberTokens {

    private static final String ERROR_NEGATIVE_NUMBER = "[ERROR] 음수는 입력할 수 없습니다.";

    private final List<Number> numbers;

    public NumberTokens(List<String> tokens) {
        this.numbers = tokens.stream()
                .map(NumberParser::parse)
                .collect(Collectors.toList());
        validateNoNegative();
    }

    private void validateNoNegative() {
        for (Number number : numbers) {
            if (number.value() < 0) {
                throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
            }
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::value)
                .sum();
    }
}