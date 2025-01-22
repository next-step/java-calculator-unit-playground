import java.util.Arrays;

public class String_Calculator {
    public  int add(String String_nums) {
        int[] nums = check(String_nums);

        int sum = nums[0];
        for (int token : Arrays.copyOfRange(nums, 1, nums.length)) {
            sum += token;
        }
        return sum;
    }


    public static int sub(String String_nums) {
        int[] nums = check(String_nums);

        int sum = nums[0];
        for (int token : Arrays.copyOfRange(nums, 1, nums.length)) {
            sum -= token;
        }
        return sum;
    }

    public static int mul(String String_nums) {
        int[] nums = check(String_nums);

        int sum = nums[0];
        for (int token : Arrays.copyOfRange(nums, 1, nums.length)) {
            sum *= token;
        }
        return sum;
    }
    
    public static int div(String String_nums) {
        int[] nums = check(String_nums);

        int sum = nums[0];
        for (int token : Arrays.copyOfRange(nums, 1, nums.length)) {
            sum /= token;
        }
        return sum;
    }

    public static int[] check(String String_nums) {
        String[] tokens = new String[String_nums.length()];

        if (String_nums.contains(",") || String_nums.contains(";")) tokens = String_nums.split("[,|;]");
        if (String_nums.contains("//")) {
            String_nums = String_nums.substring(String_nums.indexOf("\n") + 1);
            tokens = String_nums.split("[,|;]");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("-?\\d+")) {
                throw new RuntimeException("양수가 아닌 값이 입력되었습니다.");
            }
        }

        int[] nums = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }

        return nums;
    }
}
