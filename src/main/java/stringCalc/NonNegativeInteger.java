package stringCalc;

import java.util.Objects;

public class NonNegativeInteger {
    private final int value;

    public NonNegativeInteger(int value) {

        this.value = value;

        if (this.value < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다: " + value);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonNegativeInteger that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
