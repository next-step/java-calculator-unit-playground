import java.util.Arrays;

public class StringCalculator {
    public Integer StringToSumOfInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]";
        String[] words = null;

        if (str.startsWith("//")) {
            int customDelimiterIndex = str.indexOf("\n");
            if (customDelimiterIndex != -1) {
                // "//"는 인덱스 0,1을 차지할 테니, 2부터 "\n"인덱스 까지의 문자열이 delimiter가 됨.
                delimiter = str.substring(2, customDelimiterIndex);
                // "\n"문자열을 기준으로 앞의 문자열을 날리고 설정한 delimiter로 split
                words = str.substring(customDelimiterIndex + 1).split(delimiter);
            }
        } else {
            words = str.split(delimiter);
        }

        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            if (Integer.parseInt(words[i]) < 0) {
                throw new RuntimeException("negative number is not allowed");
            }
            sum += Integer.parseInt(words[i]);
        }

        return sum;
    }
}
