package cholog;

import java.util.Arrays;

public class StringCalculator {
  private final StringBuilder regex = new StringBuilder(",|:");

  int sum(String input) {
    if (input.startsWith("//")) {
      regex.append("|").append(input.charAt(2));
      input = input.substring(5);
    }

    return Arrays.stream(input.split(regex.toString()))
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
