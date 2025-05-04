import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static final String DEFAULT_DELIMITER = ",|:";
    static final String CUSTOM_REGEX = "//(.*)\n(.*)";

    int sum(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }
        List<Integer> numbers = splitInput(input);
        return numbers.stream().mapToInt(i->i).sum();
    }

    private List<Integer> splitInput(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;

        if (input.startsWith("//")) {
            Matcher customDelimiter = Pattern.compile(CUSTOM_REGEX).matcher(input);
            if (customDelimiter.matches()) {
                delimiter = finalDelimiter(customDelimiter.group(1));
                numbers = customDelimiter.group(2);
            }
        }
        String[] tokens = numbers.split(delimiter);
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            int number = stringToInt(token);
            result.add(number);
        }
        return result;
    }

    private String finalDelimiter(String input){
        if(input.length() == 1){ //delimiter가 1개라면 다시 return
            return input;
        }
        //delimiter가 2개 이상일 때
        StringBuilder result = new StringBuilder();
        result.append(Pattern.quote(String.valueOf(input.charAt(0))));
        for (int i = 1; i < input.length(); i++) {
            result.append("|").append(Pattern.quote(String.valueOf(input.charAt(i))));
        }
        return result.toString();
    }

    private int stringToInt(String token){
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {//음수라면
                throw new RuntimeException();
            }
            return number;
        } catch (NumberFormatException e) {//숫자가 아닌 값이 들어온다면
            throw new RuntimeException();
        }
    }
}
