package cholog;

import java.util.Arrays;

public class StringCalculator {
  private final StringBuilder regex = new StringBuilder(",|:");

  String parse(String input) {
    if (input.startsWith("//")) {
      regex.append("|").append(input.charAt(2));
      return input.substring(input.indexOf("\n") + 1);
    }
    return input;
  }

  int sum(String input) {
    return Arrays.stream(parse(input).split(regex.toString()))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
