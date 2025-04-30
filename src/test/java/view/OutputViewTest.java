package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("view.OutputView Test")
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
        assertThat(output).contains(OutputView.FIRST_NUMBER_PROMPT);
    }

    @Test
    @DisplayName("두 번째 숫자 입력 프롬프트를 출력한다.")
    void printSecondNumberPrompt() {
        outputView.printSecondNumberPrompt();
        String output = outputStream.toString();
        assertThat(output).contains(OutputView.SECOND_NUMBER_PROMPT);
    }

    @Test
    @DisplayName("계산 결과를 출력한다.")
    void printResult() {
        int result = 10;
        outputView.printResult(result);
        String output = outputStream.toString();
        assertThat(output).contains(OutputView.RESULT_MESSAGE + result);
    }
}
