import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    String DELIMITER = "[,|:]";
    String CUSTOM_DELIMITER = "([//])(.)([\n])";
    Pattern CUSTTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    int SUM = 0;

    public int calculate(String input) {
        String delimiter = DELIMITER;
        Matcher find_custom_delimiter = CUSTTOM_DELIMITER_PATTERN.matcher(input);
        int start_cal_index = input.indexOf("\n")+1;

        // 입력된 값이 없으면 0 반환
        if (input.length() == 0) {
            return 0;
        }

        // 커스텀 구분자를 사용하는 경우 구분자와 계산할 문자열 바꾸기
        if (find_custom_delimiter.find()){
            delimiter = find_custom_delimiter.group(2);
            input = input.substring(start_cal_index);
        }

        String[] split_input = input.split(delimiter);
        List<Integer> string_to_number = new ArrayList<>();

        // 예외처리 추가

        try {
            for (String s : split_input) {
                int token = Integer.parseInt(s);

                if (token < 0) {
                    throw new RuntimeException("음수를 입력할 수 없습니다.");
                }
                string_to_number.add(token);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("숫자가 아닌 값을 입력했습니다");
        }

        for(int i : string_to_number){
            SUM += i;
        }

        return SUM;

    }
    
}
