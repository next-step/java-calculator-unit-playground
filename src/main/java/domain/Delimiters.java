package domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final List<String> DEFAULT_DELIMITERS = List.of(COMMA, COLON);

    private final List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

    public void registerCustomDelimiter(String customDelimiter) {
        validate(customDelimiter);
        delimiters.add(customDelimiter);
    }

    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    private void validate(String customDelimiter) {
        validateNotBlank(customDelimiter);
        validateNotDuplicate(customDelimiter);
    }

    private void validateNotBlank(String customDelimiter) {
        if (customDelimiter == null || customDelimiter.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자는 비어 있을 수 없습니다.");
        }
    }

    private void validateNotDuplicate(String customDelimiter) {
        if (delimiters.contains(customDelimiter)) {
            throw new IllegalArgumentException("[ERROR] 이미 등록된 구분자입니다.");
        }
    }
}
