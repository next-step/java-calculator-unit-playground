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
      int token_len = tokens.length;

      return str_sum(token_len, tokens);
    }
    String[] tokens = input.split("[,|:]");
    int token_len = tokens.length;

    return str_sum(token_len, tokens);
  }

  private int str_sum(int token_len, String[] tokens) {
    int sum = 0;

    if(token_len == 1)
      return Integer.parseInt(tokens[0]);

    for(int i=0; i< token_len - 1; i += 2)
    {
      int a = Integer.parseInt(tokens[i]);
      int b = Integer.parseInt(tokens[i+1]);
      sum += calculator.sum(a, b);
    }
    if(token_len % 2 == 1)
      sum += Integer.parseInt(tokens[token_len-1]);

    return sum;
  }
}
