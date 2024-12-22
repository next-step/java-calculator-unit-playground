public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    return a / b;
  }

  public int add(String text) {
    if(text.length() == 0) {
      return 0;
    }

    String delimiter = ",|:";
    String str = text;

    if (text.startsWith("//")) {
      int startIndex = 2;
      int endIndex = text.indexOf("\n");
      
      if(endIndex == -1) {
        throw new RuntimeException("구분자가 없습니다.");
      }

      String customDelimiter = text.substring(startIndex, endIndex);
      delimiter = delimiter + "|" + customDelimiter;
      str = text.substring(endIndex + 1);
    }

    String[] tokens = text.split(delimiter);
    int sum = 0;

    for (String token : tokens) {
      if (token.matches("[0-9]+")) {
        int num = Integer.parseInt(token);
        sum += num;
      } else {
        throw new RuntimeException("숫자 형식이 아닌 문자열이 있습니다.");
      }
    }

    return sum;
  }
}

