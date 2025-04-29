import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomDelimiterRegisterTest {

    @Test
    @DisplayName("커스텀 구분자를 등록할 수 있다")
    void 커스텀구분자_등록() {
        // given
        Delimiters delimiters = new Delimiters();
        CustomDelimiterRegister register = new CustomDelimiterRegister(delimiters);

        // when
        register.register(";");

        // then
        List<String> expected = List.of(",", ":", ";");
        assertEquals(expected, delimiters.getDelimiters());
    }
}
