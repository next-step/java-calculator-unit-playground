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
    @DisplayName("readNumber: 입력받은 문자열을 정수로 변환하여 반환한다.")
    void readNumber() {
        System.setIn(new ByteArrayInputStream(INPUT.getBytes()));
        InputView inputView = new InputView();
        assertEquals(42, inputView.readNumber());
    }
}
