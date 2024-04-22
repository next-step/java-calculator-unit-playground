
public class Calculator {
    public static int add(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        if(i + j > Integer.MAX_VALUE || i+j <Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR]결과값이 Integer 범위 이상입니다.");
        }
        return (int) Math.round(i + j);
    }

    public static int subtract(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        if(i - j > Integer.MAX_VALUE || i-j <Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR]결과값이 Integer 범위 이상입니다.");
        }
        return (int) Math.round(i - j);
    }

    public static int multiply(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        if(i * j > Integer.MAX_VALUE || i*j <Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR]결과값이 Integer 범위 이상입니다.");
        }
        return (int) Math.round(i * j);
    }

    public static int divide(String a, String b) {
        double i = stringToDouble(a);
        double j = stringToDouble(b);
        if(j==0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다");
        }
        if(i / j > Integer.MAX_VALUE || i/j <Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR]결과값이 Integer 범위 이상입니다.");
        }
        return (int) Math.round(i / j);
    }

    public static double stringToDouble(String i) {
        try {
            return Double.parseDouble(i);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }
}
