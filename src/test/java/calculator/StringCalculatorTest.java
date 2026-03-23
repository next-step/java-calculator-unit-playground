package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("문자열 계산기")
public class StringCalculatorTest {
	
	@DisplayName("문자열 합")
	@Nested
	class SumStringTest {
		
		@DisplayName("각 숫자의 합을 반환")
		@Test
		void testSumValues() {
			assertThat(StringCalculator.sum("1")).isEqualTo(1);
			assertThat(StringCalculator.sum("2,3")).isEqualTo(5);
			assertThat(StringCalculator.sum("1:4")).isEqualTo(5);
			assertThat(StringCalculator.sum("2:1,5")).isEqualTo(8);
		}
		
		@DisplayName("구분자 변경시 각 숫자의 합을 반환")
		@Test
		void testParsing() {
			assertThat(StringCalculator.sum("//;\n4;5;6"))
					.isEqualTo(15);
			
			assertThat(StringCalculator.sum("//hallo\n" + "4" + "hallo" + "5" + "hallo" + "6"))
					.isEqualTo(15);
			
			assertThat(StringCalculator.sum("//11\n" + "4" + "11" + "5" + "11" + "6"))
					.isEqualTo(4115116);
		}
		
		@DisplayName("'표현식의 끝' 오류 발생")
		@Test
		void testThrowEndOfExpression() {
			assertThrowMessageIncludes(
					"숫자를 예상했지만 표현식이 끝",
					() -> new StringSumCalculation("").executeSum(),
					() -> StringCalculator.sum("1,")
			);
		}
		
		@DisplayName("잘못된 숫자 입력시 오류 발생")
		@Test
		void testThrowMalformedNumber() {
			assertThrowMessageIncludes(
					"올바른 숫자를 입력",
					() -> StringCalculator.sum("abc"),
					() -> StringCalculator.sum("/k"),
					() -> StringCalculator.sum("\n"),
					() -> StringCalculator.sum("1:aa")
			);
		}
		
		@DisplayName("너무 큰 숫자 입력시 오류 발생")
		@Test
		void testThrowLargeNumber() {
			assertThrowMessageIncludes(
					"올바르지 않은 숫자",
					() -> StringCalculator.sum("12345678901234567890")
			);
		}
		
		@DisplayName("'숫자 뒤에는 구분자가 와야...' 오류 발생")
		@Test
		void testThrowSeparatorExpected() {
			assertThrowMessageIncludes(
					"숫자 뒤에는 구분자가 와",
					() -> StringCalculator.sum("1a"),
					() -> StringCalculator.sum("12345;;")
			);
		}
		
		@DisplayName("execute는 한번만 호출하라는 오류 발생")
		@Test
		void testThrowCallExecuteOnce() {
			assertThrowMessageIncludes(
					"execute는 한번만 호출",
					() -> {
						StringSumCalculation calculator = new StringSumCalculation("1,2");
						calculator.executeSum();
						calculator.executeSum();
					}
			);
		}
		
		@DisplayName("음수 입력시 오류 발생")
		@Test
		void testThrowOnNegativeNumber() {
			assertThrowMessageIncludes(
					"음수는 지원되지 않습니다",
					() -> StringCalculator.sum("-3"),
					() -> StringCalculator.sum("1,-5")
			);
		}
		
		@DisplayName("구분자를 잘못 입력할 경우 오류 발생")
		@Test
		void testMalformedSeparator() {
			assertThrowMessageIncludes(
					"구분자 입력 형식이 잘못",
					() -> StringCalculator.sum("//")
			);
		}
	}
	
	
	/// 유틸리티
	
	private void assertThrowMessageIncludes(String message, ThrowableAssert.ThrowingCallable... executables) {
		for(ThrowableAssert.ThrowingCallable executable : executables) {
			assertThatThrownBy(executable).hasMessageContaining(message);
		}
	}
}
