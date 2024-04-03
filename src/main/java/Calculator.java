public class Calculator {
    public static int add(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        return (int) (i + j);
    }

    public static int subtract(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        return (int) (i - j);
    }

    public static int multiply(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        return (int) (i * j);
    }

    public static int divide(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
//        if(j==0) throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다");
        return (int) (i / j);
    }

    public static double stringToDouble(String i) {
        try {
            return Double.parseDouble(i);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
