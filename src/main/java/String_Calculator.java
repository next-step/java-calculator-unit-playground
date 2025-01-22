public class String_Calculator {
    public  int add(String nums) {
        if (nums == null || nums.isEmpty()) return 0;
        String[] tokens = new String[nums.length()];

        if (nums.contains(",") || nums.contains(";")) tokens = nums.split("[,|;]");
        if (nums.contains("//")) {
            nums = nums.substring(nums.indexOf("\n") + 1);
            tokens = nums.split("[,|;]");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("-?\\d+")) {
                throw new RuntimeException("양수가 아닌 값이 입력되었습니다.");
            }
        }

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
    public static int sub(String nums) {
        if (nums == null || nums.isEmpty()) return 0;
        String[] tokens = new String[nums.length()];

        if (nums.contains(",") || nums.contains(";")) tokens = nums.split("[,|;]");
        if (nums.contains("//")) {
            nums = nums.substring(nums.indexOf("\n") + 1);
            tokens = nums.split("[,|;]");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("-?\\d+")) {
                throw new RuntimeException("양수가 아닌 값이 입력되었습니다.");
            }
        }

        int sum = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            sum -= Integer.parseInt(tokens[i]);
        }
        return sum;
    }

    public static int mul(String nums) {
        if (nums == null || nums.isEmpty()) return 0;
        String[] tokens = new String[nums.length()];

        if (nums.contains(",") || nums.contains(";")) tokens = nums.split("[,|;]");
        if (nums.contains("//")) {
            nums = nums.substring(nums.indexOf("\n") + 1);
            tokens = nums.split("[,|;]");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("-?\\d+")) {
                throw new RuntimeException("양수가 아닌 값이 입력되었습니다.");
            }
        }

        int sum = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            sum *= Integer.parseInt(tokens[i]);
        }
        return sum;
    }
    
    public static int div(String nums) {
        if (nums == null || nums.isEmpty()) return 0;
        String[] tokens = new String[nums.length()];

        if (nums.contains(",") || nums.contains(";")) tokens = nums.split("[,|;]");
        if (nums.contains("//")) {
            nums = nums.substring(nums.indexOf("\n") + 1);
            tokens = nums.split("[,|;]");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].matches("-?\\d+")) {
                throw new RuntimeException("양수가 아닌 값이 입력되었습니다.");
            }
        }

        int sum = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            sum /= Integer.parseInt(tokens[i]);
        }
        return sum;
    }
}
