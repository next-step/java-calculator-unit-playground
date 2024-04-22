import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringCalculator {
    public static int sum(String input){
        int output = 0;
        int[] nums = stringToIntArray(input);
        for(int num : nums){
            output += num;
        }
        return output;
    }

    public static int[] stringToIntArray(String input){
        String customDelimiter = "";
        if(input.substring(0,2).equals("//")){
            customDelimiter = input.substring(2).split("\n")[0];
            input = input.split("\n")[1];
        }
        String regex = ",|:";
        HashSet<String> set = new HashSet<>();
        set.addAll(List.of("{", "}", ".", "*", "+", "?", "^", "$","\\", "|"));
        if(customDelimiter.length() > 0) {
            if(set.contains(customDelimiter)){
                regex += "|" + "\\" + customDelimiter;
            }
            else{
                regex += "|" + customDelimiter;
            }
        }
        return Arrays.stream(input.split(regex))
                .mapToInt(token -> parseToValidInteger(token))
                .toArray();
    }

    private static int parseToValidInteger(final String token){
        try{
            final int num = Integer.parseInt(token);
            if(num>9 || num<0){
                throw new RuntimeException();
            }
            return num;
        }catch(NumberFormatException e){
            throw new RuntimeException();
        }
    }
}
