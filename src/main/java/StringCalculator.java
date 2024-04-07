public class StringCalculator {
    public static int sum(String input){
        int output = 0;
        int[] nums = stringToIntArray(input);
        for(int num : nums){
            output += num;
        }
        return output;
    }

    public static int[] stringToIntArray(String input){
        String customDelimiter = "";
        if(input.substring(0,2).equals("//")){
            customDelimiter = input.substring(2).split("\n")[0];
        }
        String regex = ",|:";
        if(customDelimiter.length() > 0) {
            if(customDelimiter.equals(".")){
                regex += "|" + "\\.";
            }else{
                regex += "|" + customDelimiter;
            }
        }
        String[] tokens = input.split(regex);
        int[] res = new int[tokens.length];
        int idx = 0;
        for(String token : tokens){
            try{
                int num = Integer.parseInt(token);
                if(num>9 || num<0){
                    throw new RuntimeException();
                }
                res[idx++] = num;
            }catch(Exception e){
                throw new RuntimeException();
            }
        }
        return res;
    }
}
