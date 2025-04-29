package domain;

import utils.NumberParser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<String> tokens) {
        this.numbers = tokens.stream()
                .map(NumberParser::parse)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::value)
                .sum();
    }
}