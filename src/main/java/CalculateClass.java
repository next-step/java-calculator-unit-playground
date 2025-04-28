public class CalculateClass {
    public int[] calculate(int a, int b) {
        int plus = a + b;
        int min = (a > b) ? (a - b) : (b - a);
        int mul = a * b;
        int div = a / b;

        int[] result = {plus, min, mul, div};
        return result;
    }
}
