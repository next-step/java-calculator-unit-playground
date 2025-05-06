package stringCalc;

import java.util.Objects;

public class PositiveNumber {

    // vo의 불변성 - final
    private final int value;

    public PositiveNumber(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다: " + value);
        }

        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다: " + value);
        }
    }

    public int getValue() {
        return value;
    }


    // vo의 동등성
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositiveNumber that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
