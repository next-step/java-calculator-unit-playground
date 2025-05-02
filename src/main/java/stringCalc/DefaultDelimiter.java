package stringCalc;

import java.util.List;

public enum DefaultDelimiter {
    COMMA(","),
    COLON (":");

    private final String symbol;

    DefaultDelimiter(String symbol){
        this.symbol = symbol;
    }

    private String getSymbol(){
        return symbol;
    }

    public static List<String> getSymbolsAsList(){
        return List.of(COMMA.getSymbol(),COLON.getSymbol());
    }
}
