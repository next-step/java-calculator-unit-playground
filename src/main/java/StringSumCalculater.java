import java.util.Arrays;

public class StringSumCalculater {

    InputToNumberProvider inputToNumberProvider = new InputToNumberProvider();

    public int add(String input) {
        int[] numbers = inputToNumberProvider.getNumbers(input);
        return Arrays.stream(numbers).sum();
    }
}
