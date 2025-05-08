package stringCalc;

import java.util.List;

public class ValueValidator {

    public static void validate(List<String> values) {
        for (String value : values) {
            validateIsNumber(value);
            validateNonNegativeNum(value);
        }
    }

    private static void validateIsNumber(String value){
        try{
            Integer.parseInt(value);
        }catch(NumberFormatException e){
            throw new RuntimeException("숫자가 아닌 값이 포함되었습니다. : " + value);
        }
    }
    private static void validateNonNegativeNum(String value) {
        if (Integer.parseInt(value) < 0) {
            throw new RuntimeException("음수 값이 포함되어 있습니다. : " + value);
        }
    }
}
