public class StringCalculator
{
    // inputStr에서 커스텀 구분자가 존재한다면 구분자 리턴, 존재하지 않으면 빈 문자열 리턴
    private String[] customCheck(String inputStr)
    {
        // "//" 체크
        if (inputStr.indexOf("//") != 0)
            return new String[]{""};

        // "\n" 체크
        int customEnd = inputStr.indexOf("\\n");
        if (customEnd == -1)
            return new String[]{""};

        // 구분자 반환
        return inputStr.substring(2, customEnd).split("");
    }

    // inputStr에서 커스텀 구분자를 이용해 구분한 결과 반환
    public String[] strCalculator(String inputStr) {
        String splitStr = ",|:";

        // 커스텀 구분자 체크
        if (inputStr.length() == 0)
            return new String[] {"0"};
        else if (inputStr.length() >= 4) {
            String[] customSplitStr = customCheck(inputStr);
            // 커스텀 구분자가 있는 경우
            if (!customSplitStr[0].equals("")) {
                for (String s : customCheck(inputStr)) {
                    splitStr = splitStr.concat("|");
                    splitStr = splitStr.concat(s);
                }

                int customEnd = inputStr.indexOf("\\n");
                return inputStr.substring(customEnd + 2).split(String.valueOf(splitStr));
            }
        }

        // 커스텀 구분자가 없는 경우
        return inputStr.split(String.valueOf(splitStr));
    }

    // inputStr을 커스텀 구분자로 구분하고 합 반환
    public int sumCalculator(String inputStr)
    {
        String[] num = strCalculator(inputStr);
        int sum = 0;
        for (String x: num) {
            // 예외 처리
            try
            {
                int intX = Integer.parseInt(x);
                if (intX < 0)
                    throw new IllegalArgumentException("음수는 입력 불가능합니다.");
                else
                    sum += intX;
            }
            catch (NumberFormatException e)
            {
                throw new RuntimeException("숫자가 아닌 값이 입력되었습니다: '" + x + "'");
            }
        }
        return sum;
    }
}