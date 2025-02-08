public class StringCalculator {
    public Long StringToSumOfLong(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }

        String delimiter = "[,|:]";

        if (str.startsWith("//")) {
            int customDelimiterIndex = str.indexOf("\n");
            if (customDelimiterIndex != -1) {
                // "//"는 인덱스 0,1을 차지할 테니, 2부터 "\n"인덱스 까지의 문자열이 delimiter가 됨.
                delimiter = str.substring(2, customDelimiterIndex);
            }
        }

        Long sum = 0L;
        String[] words = str.split(delimiter);

        for(int i=0; i<words.length; i++) {
            if (Long.parseLong(words[i]) < 0) {
                throw new RuntimeException("negative number is not allowed");
            }
            sum += Long.parseLong(words[i]);
            i++;
        }
        return sum;
    }
}