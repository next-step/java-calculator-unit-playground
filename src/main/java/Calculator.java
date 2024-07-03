public class Calculator {
    public int add(int x, int y){
        return x + y;
    }

    public int minus(int x, int y){
        return x - y;
    }

    public int multiple(int x, int y){
        return x * y;
    }

    public int divide(int x, int y){
        return x / y;
    }

    public int stringAdd(String str){
        String custom = "";

        if(str == null) {
            throw new NullPointerException("문자열이 비었습니다!");
        }

        int total = 0;

        if(!str.isBlank() && str.charAt(0) == '/'){
            custom = String.valueOf(str.charAt(2));
            str = str.substring(4);
        }
        String[] nums = str.split("[,:" + custom + "]");

        for(String strNum : nums){
            try {
                if(str.isBlank()){
                    total = 0;
                    break;
                }
                int num = Integer.parseInt(strNum);
                if(num < 0){
                    throw new RuntimeException();
                }
                total += num;
            } catch (Exception e){
                throw new RuntimeException("잘못된 문자열입니다!");
            }
        }

        return total;
    }
}
