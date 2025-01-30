public class CalculatorTest {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println(calc.add(10, 20));
        System.out.println(calc.add(10, -5));
        System.out.println(calc.subtract(10, 20));
        System.out.println(calc.multiply(10, 20));
        System.out.println(calc.divide(10, 5));


    }
}
