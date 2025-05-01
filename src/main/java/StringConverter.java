import java.util.List;

public class StringConverter {

    public List<Integer> convertAndValidateNumbers(final List<String> tokens) {
        try {
            List<Integer> numbers = tokens.stream()
                    .map(Integer::parseInt)
                    .toList();

            checkNegativeNumbers(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 다른 값이 입력되었습니다.");
        }
    }

    private void checkNegativeNumbers(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다.");
            }
        }
    }
}
