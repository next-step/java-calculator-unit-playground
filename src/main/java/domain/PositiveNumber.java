package domain;

import java.util.Objects;

public class PositiveNumber {

    private static final String ERROR_NEGATIVE_NUMBER = "[ERROR] 숫자는 0 이상이어야 합니다.";

    private final int positiveNumber;

    public PositiveNumber(int positiveNumber) {
        validateNonNegative(positiveNumber);
        this.positiveNumber = positiveNumber;
    }

    private void validateNonNegative(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(positiveNumber);
    }
}
