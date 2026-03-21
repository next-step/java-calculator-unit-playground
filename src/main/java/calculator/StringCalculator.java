package calculator;

public class StringCalculator {
    String[] setCustomSplit(String str){
        int postfixDelimiterIndex = str.indexOf("\n");
        int prefixDelimiterIndex = 2;
        String customDelimiter = str.substring(prefixDelimiterIndex, postfixDelimiterIndex);
        // Delimiter의 인덱스가 '\'를 기준으로 잡혀있으므로 +1로 n도 건너뛰기
        String targetString = str.substring(postfixDelimiterIndex + 1);
        return targetString.split(customDelimiter);

    }
    String[] basicSplit(String str){
        return str.split("[,|:]");
    }

    int addAll(String[] nums){
        int numOfInt = nums.length;
        int sum = 0;
        for (int i = 0; i<numOfInt; i++){
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }
}