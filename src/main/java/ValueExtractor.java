
public class ValueExtractor {
  public static String[] extractValueByString(String value) {
    StringBuilder regex = new StringBuilder("[,");

    for (String s : value.split("\n"))
      if(s.contains("//"))
        regex.append("|").append(s.substring(2));
      else
        value = s;

    return value.split(regex.append("]").toString());
  }
}
