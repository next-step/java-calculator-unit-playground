package domain;

import utils.NumberParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<String> tokens) {
        this.positiveNumbers = tokens.stream()
                .map(NumberParser::parse)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int sum() {
        return positiveNumbers.stream()
                .mapToInt(PositiveNumber::getPositiveNumber)
                .sum();
    }
}
