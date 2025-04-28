import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("OutputView Test")
class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("첫 번째 숫자 입력 프롬프트를 출력한다.")
    void printFirstNumberPrompt() {
        outputView.printFirstNumberPrompt();
        String output = outputStream.toString();
        assertTrue(output.contains(OutputView.FIRST_NUMBER_PROMPT));
    }
}
