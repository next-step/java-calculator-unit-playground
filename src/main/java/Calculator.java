class Calculator {
    public static int add(int n, int m){
        try {
            return Math.addExact(n, m);
        } catch (ArithmeticException e) {
            System.err.println("오버플로우 발생: " + e.getMessage());
            return Integer.MAX_VALUE;
        }
    }

    public static int subtract(int n, int m){
        try {
            return Math.subtractExact(n ,m);
        } catch (ArithmeticException e) {
            System.err.println("오버플로우 발생: " + e.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    public static int multiply(int n, int m){
        try {
            return Math.multiplyExact(n ,m);
        } catch (ArithmeticException e) {
            System.err.println("오버플로우 발생: " + e.getMessage());
            return 0;
        }
    }

    // 얘는 내 머릿속에서 오버플로우가 되는 상상이 안감
    public static int divide(int n, int m) {
        if (m == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return n / m;
    }
}
