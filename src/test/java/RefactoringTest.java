import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class RefactoringTest {
    @Nested
    public class TestFunction {
        @Test
        @DisplayName("문자열 테스트")
        void stringTest() {
            StringCalculator c = new StringCalculator();
            try{
                assertThat(c.sumCalculator("")).isEqualTo(0);
                assertThat(c.sumCalculator("1,2")).isEqualTo(3);
                assertThat(c.sumCalculator("1,2,3")).isEqualTo(6);
                assertThat(c.sumCalculator("1,2:3")).isEqualTo(6);
                assertThat(c.sumCalculator("//;\\n1;2;3")).isEqualTo(6);
                assertThat(c.sumCalculator("//;123\\n4;4;5162637")).isEqualTo(32);
                assertThat(c.sumCalculator("//;6\\n4;4;516261;37")).isEqualTo(99);
            }
            catch (AssertionError e)
            {
                assertThat(e).hasMessage("에러 발생");
            }
        }
    }
}
