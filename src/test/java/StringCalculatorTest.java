import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기 JUnit5 테스트")
public class StringCalculatorTest {
    @DisplayName("문자열 계산기 덧셈 테스트")
    @Test
    public void addTest() {
        assertEquals(11, StringCalculator.sum("6:5"));
        assertEquals(15, StringCalculator.sum("//'\n6'5:4"));
        assertEquals(23, StringCalculator.sum("6:5,7,5"));
        assertThrows(RuntimeException.class, () -> StringCalculator.sum("6,6;7;3"));
        assertThrows(RuntimeException.class, () -> StringCalculator.sum("//}\n6,6,;3"));
    }

    @DisplayName("문자열 계산기 덧셈 테스트 AssertJ")
    @Test
    public void addAssertJTest() {
        assertThat(StringCalculator.sum("6:5")).isEqualTo(11);
        assertThat(StringCalculator.sum("//'\n6'5:4")).isEqualTo(15);
        assertThat(StringCalculator.sum("6:5,7,5")).isEqualTo(23);
        assertThatThrownBy(() -> {
            StringCalculator.sum("6,6;7;3");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            StringCalculator.sum("//}\n6,6,;3");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            StringCalculator.sum("4:-5:7");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            StringCalculator.sum("일:오:7");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기 전처리 테스트 AssertJ")
    @Test
    public void stringToIntArrayAssertJTest(){
        assertThat(StringCalculator.stringToIntArray("6:5")).isEqualTo(new int[] {6,5});
        assertThat(StringCalculator.stringToIntArray("//'\n6'5'4")).isEqualTo(new int[] {6,5,4});
        assertThat(StringCalculator.stringToIntArray("//|\n6|5,4")).isEqualTo(new int[] {6,5,4});
        assertThatThrownBy(() -> {
            StringCalculator.stringToIntArray("//}\nㄱ,j,3"
            );
        }).isInstanceOf(RuntimeException.class);
    }
}