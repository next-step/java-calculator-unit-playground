package calculator;

public class StringCalculator {
    String[] setCustomSplit(String str){
        int idx = str.indexOf("\n");
        String Custom = str.substring(2, idx);
        String target = str.substring(idx + 1);
        return target.split(Custom);

    }
    String[] basicSplit(String str){
        return str.split("[,|:]");
    }

    int addAll(String[] nums){
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i<len; i++){
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }
}
