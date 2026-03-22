package calculator;

public class StringCalculator {
	public static int sum(String expression) {
		StringSumCalculation calculation = new StringSumCalculation(expression);
		return calculation.executeSum();
	}
}
