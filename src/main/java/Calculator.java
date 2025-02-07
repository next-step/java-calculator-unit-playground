import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Calculator {

    private static final Set<String> BASIC_SEPARATORS = Set.of(",", ":");
    private static final String CUSTOM_SEPARATOR_STARTER = "//";
    private static final String CUSTOM_SEPARATOR_TERMINATOR = "\n";

    public int add(int a, int b) {
        validateOperation(a, b, Operator.ADD);

        return a + b;
    }

    public int subtract(int a, int b) {
        validateOperation(a, b, Operator.SUBTRACT);

        return a - b;
    }

    public int multiply(int a, int b) {
        validateOperation(a, b, Operator.MULTIPLY);

        return a * b;
    }

    public int divide(int a, int b) {
        validateOperation(a, b, Operator.DIVIDE);

        return a / b;
    }

    /**
     * 구분자를 가진 문자열을 받아 모든 숫자의 합을 반환한다. <br>
     * 쉼표 또는 콜론을 기본 구분자로 사용한다. <br>
     * 커스텀 구분자를 사용하고 싶을 경우, 문자열 앞부분에 "//${커스텀구분자}\n"을 추가한다. <br>
     * ex_ "//;\n1;2;3" <br>
     *
     * @param input 구분자로 구분된 자연수 양수를 지닌 문자열
     * @return 모든 숫자의 합
     * @throws RuntimeException 구분자가 부적절함<br>숫자 이외의 값이 전달됨<br>음수가 전달됨
     */
    public int addAll(String input) {
        String separator = getSeparatorFromInput(input);
        List<Integer> numbers = convertInputIntoList(input, separator);

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    private String getSeparatorFromInput(String input) {
        // 문자열이 숫자로 시작할 경우 기본 구분자를 사용하는 것이라 판단하고, 기본 구분자를 찾아 반환한다
        if (isStartsWithDigit(input)) {
            return getBasicSeparatorFromInput(input);
        }

        // 커스텀 구분자의 형식이 올바른지 검사한다
        if (!hasProperCustomSeparator(input)) {
            throw new RuntimeException("커스텀 구분자의 형식이 올바르지 않습니다.");
        }

        // 커스텀 구분자를 추출해 반환한다
        int indexOfTerminator = input.indexOf(CUSTOM_SEPARATOR_TERMINATOR);
        return input.substring(CUSTOM_SEPARATOR_STARTER.length(), indexOfTerminator);
    }

    private List<Integer> convertInputIntoList(String input, String separator) {
        List<Integer> numbers = new ArrayList<>();

        // 커스텀 구분자일 경우, 커스텀 구분자 선언 부분을 자른다
        if (isCustomSeparator(separator)) {
            input = input.substring(CUSTOM_SEPARATOR_STARTER.length() + CUSTOM_SEPARATOR_TERMINATOR.length() + separator.length());
        }

        StringTokenizer tokenizer = new StringTokenizer(input, separator);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (!isDigit(token)) {
                throw new RuntimeException("숫자 이외의 값은 전달할 수 없습니다.");
            }
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private String getBasicSeparatorFromInput(String string) {
        for (String basicSeparator : BASIC_SEPARATORS) {
            if (string.contains(basicSeparator)) {
                return basicSeparator;
            }
        }

        throw new RuntimeException("적절한 구분자를 찾지 못했습니다.");
    }

    private boolean hasProperCustomSeparator(String string) {
        // 시작점과 끝점이 존재하는지 확인한다
        int startIndex = string.indexOf(CUSTOM_SEPARATOR_STARTER);
        int endIndex = string.indexOf(CUSTOM_SEPARATOR_TERMINATOR);
        if (isNegative(startIndex) || isNegative(endIndex)) {
            return false;
        }

        // 커스텀 구분자의 시작점이 문자열의 맨 앞에 있는지 확인한다
        if (!isZero(startIndex)) {
            return false;
        }

        // 시작점과 끝점 형식이 일치하는지 확인한다
        String actualStarter = string.substring(startIndex, CUSTOM_SEPARATOR_STARTER.length());
        String actualTerminator = string.substring(endIndex, endIndex + CUSTOM_SEPARATOR_TERMINATOR.length());
        if (!actualStarter.equals(CUSTOM_SEPARATOR_STARTER) || !actualTerminator.equals(CUSTOM_SEPARATOR_TERMINATOR)) {
            return false;
        }

        // 커스텀 구분자의 길이가 1을 넘을 경우에만 올바르다 판단한다
        return isBiggerThanZero(endIndex - CUSTOM_SEPARATOR_STARTER.length());
    }

    private boolean isStartsWithDigit(String string) {
        return Character.isDigit(string.charAt(0));
    }

    private boolean isDigit(String string) {
        for (char word : string.toCharArray()) {
            if (!Character.isDigit(word)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    private boolean isZero(int number) {
        return number == 0;
    }

    private boolean isBiggerThanZero(int number) {
        return number > 0;
    }

    private boolean isCustomSeparator(String separator) {
        return !BASIC_SEPARATORS.contains(separator);
    }

    private void validateOperation(int a, int b, Operator operator) {
        switch (operator) {
            case ADD, SUBTRACT, MULTIPLY -> {
                validateOverflow(a, b, operator);
                validateUnderflow(a, b, operator);
            }
            case DIVIDE -> validateDivide(b);
        }
    }

    private void validateOverflow(int a, int b, Operator operator) {
        switch (operator) {
            case ADD -> {
                if ((long) a + (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) + (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
            case SUBTRACT -> {
                if ((long) a - (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) - (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
            case MULTIPLY -> {
                if ((long) a * (long) b > Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) * (%d)는 오버플로우가 발생합니다.", a, b));
                }
            }
        }
    }

    private void validateUnderflow(int a, int b, Operator operator) {
        switch (operator) {
            case ADD -> {
                if ((long) a + (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) + (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
            case SUBTRACT -> {
                if ((long) a - (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) - (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
            case MULTIPLY -> {
                if ((long) a * (long) b < Integer.MIN_VALUE) {
                    throw new IllegalArgumentException(String.format("(%d) * (%d)는 언더플로우가 발생합니다.", a, b));
                }
            }
        }
    }

    private void validateDivide(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
