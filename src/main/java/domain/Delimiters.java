package domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final List<String> DEFAULT_DELIMITERS = List.of(COMMA, COLON);

    private final List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);

    public void addCustomDelimiters(String customDelimiter) {
        if (customDelimiter == null || customDelimiter.isEmpty()) {
            return;
        }
        delimiters.add(customDelimiter);
    }

    public List<String> getDelimiters() {
        return new ArrayList<>(delimiters);
    }
}
