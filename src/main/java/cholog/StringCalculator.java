package cholog;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
  private final StringBuilder seperators = new StringBuilder(",|:");

  String parse(String input) {
    seperators.append("|").append(input.charAt(2));
    return input.substring(input.indexOf("\n") + 1);
  }

  int sum(String input){
    int result = 0;
    String[] nums;

    if (input.startsWith("//")) {
      input = parse(input);
    }

    nums = input.split(seperators.toString());
    for (String n : nums){
      if (n.startsWith("-")) {
        throw new RuntimeException();
      }
      try{
        result += Integer.parseInt(n);
      } catch (NumberFormatException e){
        throw new RuntimeException();
      }
    }
    return result;
  }
}
