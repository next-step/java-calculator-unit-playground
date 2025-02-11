import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void basicAdd() {
        assertThat(stringCalculator.StringToSumOfInt("1,2")).as("The result 1 + 2 must be 3").isEqualTo(3);
    }

    @Test
    void customDelimiterAdd() {
        assertThat(stringCalculator.StringToSumOfInt("//q\n1q2")).as("The result 1 + 2 must be 3").isEqualTo(3);
    }

    @Test
    void givenEmptyString() {
        assertThat(stringCalculator.StringToSumOfInt("")).as("The result must be 0").isEqualTo(0);
    }

    @Test
    void givenNegativeNumberCheckRuntimeException() {
        assertThatThrownBy(() -> {
                    stringCalculator.StringToSumOfInt("-1");
                }
        ).isInstanceOf(RuntimeException.class);
    }
}
