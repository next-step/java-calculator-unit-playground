public class StringCalculator {
  Calculator calculator = new Calculator();

  int sum(String input) {
    if(input.startsWith("//"))
    {
      int startIndex = input.indexOf("//");
      int endIndex = input.indexOf("\n");

      String separator = input.substring(startIndex+2, endIndex);
      String expression = input.substring(endIndex+1);

      String[] tokens = expression.split(separator);

      return str_sum(tokens);
    }
    String[] tokens = input.split("[,|:]");

    return str_sum(tokens);
  }

  private int str_sum(String[] tokens) {
    int sum = 0;

    for(String token : tokens) {
      int number = parseAndValidateNumber(token);

      if(number < 0)
        throw new RuntimeException();

      sum += number;
    }

    return sum;
  }

  private int parseAndValidateNumber(String input) {
    try {
      return Integer.parseInt(input);
    } catch(NumberFormatException e) {
      throw new RuntimeException();
    }
  }
}
