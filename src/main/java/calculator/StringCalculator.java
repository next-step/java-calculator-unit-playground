package calculator;

public class StringCalculator extends Calculator{
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
            try {
                int x = Integer.parseInt(nums[i]);
                if (x < 0){
                    throw new RuntimeException("음수는 전달할 수 없습니다.");
                }
                sum = this.add(sum, x);
            } catch (NumberFormatException e){
                throw new RuntimeException("숫자가 아닙니다.");
            }
        }
        return sum;
    }
}
