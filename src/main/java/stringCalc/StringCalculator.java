package stringCalc;

import java.util.List;


public class StringCalculator {
    public static int add(String input) {

        if (input == null || input.isEmpty()){
            return 0;
        }

        DelimiterAndBodyInfo info = CustomDelimiterAndBodyExtractor.extract(input);
        List<String> values =  StringParser.parse(info.getDelimiter(),info.getBody());

        int sum = 0;
        for(String value : values){
            sum += Integer.parseInt(value);
        }

        return sum;
    }



}
