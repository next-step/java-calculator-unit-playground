package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    @DisplayName("value 메서드는 저장된 값을 반환한다.")
    void valueMethodReturnsStoredValue() {
        Number number = new Number(42);
        assertEquals(42, number.value());
    }

    @Test
    @DisplayName("동일한 값을 가진 Number 객체는 equals로 비교 시 같다.")
    void numbersWithSameValueAreEqual() {
        Number number1 = new Number(42);
        Number number2 = new Number(42);
        assertEquals(number1, number2);
    }

    @Test
    @DisplayName("다른 값을 가진 Number 객체는 equals로 비교 시 다르다.")
    void numbersWithDifferentValuesAreNotEqual() {
        Number number1 = new Number(42);
        Number number2 = new Number(43);
        assertNotEquals(number1, number2);
    }

    @Test
    @DisplayName("음수 값을 가진 경우 예외가 발생한다.")
    void throwsExceptionWhenNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Number(-1));
    }
}
