package stringCalc;

import java.util.List;

import static stringCalc.CustomDelimiterAndBodyExtractor.extract;
import static stringCalc.StringParser.parse;

public class StringCalculator {
    public static int add(String input) {

        if (input == null || input.isEmpty() ){
            return 0;
        }

        DelimiterAndBodyInfo info = extract(input);
        List<String> values =  parse(info.getDelimiter(),info.getBody());

        int sum = 0;
        for(String value : values){
            sum += Integer.parseInt(value);
        }

        return sum;
    }



}
