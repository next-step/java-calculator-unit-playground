import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("InputView Test")
class InputViewTest {

    private static final String INPUT = "42\n";
    private static final InputStream ORIGINAL_IN = System.in;

    @AfterEach
    void tearDown() {
        System.setIn(ORIGINAL_IN);
    }

    @Test
    @DisplayName("readInput: 입력받은 문자열을 그대로 반환한다.")
    void readExpression() {
        System.setIn(new ByteArrayInputStream(INPUT.getBytes()));
        InputView inputView = new InputView();
        assertEquals("42", inputView.readExpression());
    }
}
