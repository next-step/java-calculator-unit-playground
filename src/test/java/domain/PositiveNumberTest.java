package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositiveNumberTest {

    @Test
    @DisplayName("getPositiveNumber 메서드는 저장된 값을 반환한다.")
    void getPositiveNumberReturnsStoredValue() {
        PositiveNumber positiveNumber = new PositiveNumber(42);
        assertThat(positiveNumber.getPositiveNumber()).isEqualTo(42);
    }

    @Test
    @DisplayName("동일한 값을 가진 PositiveNumber 객체는 equals로 비교 시 같다.")
    void positiveNumbersWithSameValueAreEqual() {
        PositiveNumber a = new PositiveNumber(42);
        PositiveNumber b = new PositiveNumber(42);
        assertThat(a).isEqualTo(b);
    }

    @Test
    @DisplayName("서로 다른 값을 가진 PositiveNumber 객체는 equals로 비교 시 다르다.")
    void positiveNumbersWithDifferentValuesAreNotEqual() {
        PositiveNumber a = new PositiveNumber(42);
        PositiveNumber b = new PositiveNumber(43);
        assertThat(a).isNotEqualTo(b);
    }

    @Test
    @DisplayName("음수 값으로 생성 시 예외가 발생한다.")
    void throwsExceptionWhenNegativeValueProvided() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 0 이상이어야 합니다.");
    }
}
