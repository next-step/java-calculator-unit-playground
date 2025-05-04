import java.util.regex.Pattern;

public class StringCalculator {

    public int sum(String str) {
        if (str == null || str.isEmpty()) {
            return 404;
        }

        if (str.contains("-")) {
            throw new RuntimeException("입력한 문자열은 음수입니다");
        }

        if (!str.matches("[0-9,:\n/;]*")) {
            // 숫자 외 다른 문자가 입력된다면
            throw new RuntimeException("숫자 이외의 다른 문자가 포함되어 있습니다");
        }

        String delimiter = "[,:]";
        // 기본 구분자는 쉼표와 클론
        if (str.startsWith("//")) {
            // 문자열이 //로 시작된다면 커스텀 구분자가 있다고 인지
            int newlineIdx = str.indexOf("\n");
            // \n을 찾아 숫자와 구분자를 나눔
            if (newlineIdx == -1) throw new RuntimeException("커스텀 구분자 형식 오류");
            // 만일 \n이 없다면 예외 처리로 던짐

            String customDel = str.substring(2, newlineIdx);
            // //부터 \n 전까지 추출
            delimiter = Pattern.quote(customDel);
            // Pattern.quote 을 사용하여 정규식 특수문자를 문자열로 변경
            // "1:2.3" 으로 입력받은 문자열을 ["1", "2", "3"] 으로??
            str = str.substring(newlineIdx + 1);
            // 문자열 자르기
        }

        String[] delimiterArrays = str.split(delimiter);
        // 구분자를 기준으로 문자열을 잘라냄
        int total = 0;

        for (String delimiterString : delimiterArrays) {
            if (!delimiterString.isEmpty()) total += Integer.parseInt(delimiterString);
        }

        return total;
    }
}
