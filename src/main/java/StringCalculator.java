import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class StringCalculator {
    public int totalNumInString(String str) {
        String criteria = ",|:";

        if (str.startsWith("//")) {
            int criteriaEndIndex = str.indexOf("\n");
            if (criteriaEndIndex == -1) {
                throw new RuntimeException("커스텀 구분자 지정에 개행 문자가 필요합니다.");
            }
            criteria = str.substring(2, criteriaEndIndex);
            str = str.substring(criteriaEndIndex + 1);
        }

        String[] strs = str.split(criteria);
        List<Integer> numbers = new ArrayList<>();

        for (String s : strs) {
            if (s == null) continue;
            try {
                int number = Integer.parseInt(s);
                if (number < 0) {
                    throw new RuntimeException("구분자 사이에 음수를 사용할 수 없습니다.");
                }
                    numbers.add(number);
            }

            catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닌 것은 계산할 수 없습니다.");
            }
        }

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
