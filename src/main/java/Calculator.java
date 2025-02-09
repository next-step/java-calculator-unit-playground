import java.util.*;
import java.util.logging.Logger;

import static util.CalculatorUtil.*;

public class Calculator {

    private static final Set<String> BASIC_SEPARATORS = CalculatorConstant.BASIC_SEPARATORS;
    private static final String CUSTOM_SEPARATOR_STARTER = CalculatorConstant.CUSTOM_SEPARATOR_STARTER;
    private static final String CUSTOM_SEPARATOR_TERMINATOR = CalculatorConstant.CUSTOM_SEPARATOR_TERMINATOR;
    private static final String BASIC_REGEX = createBasicRegex(BASIC_SEPARATORS);

    private final Logger logger = Logger.getLogger("Calculator Logger");

    public int add(int leftOperand, int rightOperand) {
        return Operator.ADD.operate(leftOperand, rightOperand);
    }

    public int subtract(int leftOperand, int rightOperand) {
        return Operator.SUBTRACT.operate(leftOperand, rightOperand);
    }

    public int multiply(int leftOperand, int rightOperand) {
        return Operator.MULTIPLY.operate(leftOperand, rightOperand);
    }

    public int divide(int dividend, int divisor) {
        return Operator.DIVIDE.operate(dividend, divisor);
    }

    /**
     * 구분자를 가진 문자열을 받아 모든 숫자의 합을 반환한다. <br>
     * 쉼표 또는 콜론을 기본 구분자로 사용한다. <br>
     * 커스텀 구분자를 사용하고 싶을 경우, 문자열 앞부분에 "//${커스텀구분자}\n"을 추가한다. <br>
     * 정규 표현식을 사용하기 때문에, 정규 표현식의 특수 문자를 커스텀 구분자로 사용할 경우 문제가 발생할 수 있다. <br>
     * ex_ "//;\n1;2;3" <br>
     *
     * @param input 구분자로 구분된 자연수 양수를 지닌 문자열
     * @return 모든 숫자의 합
     * @throws RuntimeException 구분자가 부적절함<br>숫자 이외의 값이 전달됨<br>음수가 전달됨
     */
    public int addAll(String input) {
        List<Integer> numbers;

        if (isStartsWithCustomSeparatorStarter(input)) {
            String customSeparator = getCustomSeparatorFromInput(input);
            String extractedInput = removeCustomSeparatorDeclarationFromInput(input);
            SafetyCustomSeparatorMapper safetyMapper = new SafetyCustomSeparatorMapper(customSeparator, extractedInput);

            String regex = createRegexByCustomSeparator(safetyMapper.getSafetyCustomSeparator());
            logger.info("생성된 Regex: " + regex);
            numbers = convertStringNumbersIntoList(safetyMapper.getSafetyExtractedInput(), regex);
        } else {
            logger.info("BASIC_REGEX 사용: " + BASIC_REGEX);
            numbers = convertStringNumbersIntoList(input, BASIC_REGEX);
        }

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    private String removeCustomSeparatorDeclarationFromInput(String input) {
        int endIndex = input.indexOf(CUSTOM_SEPARATOR_TERMINATOR);

        return input.substring(endIndex + CUSTOM_SEPARATOR_TERMINATOR.length());
    }

    private String getCustomSeparatorFromInput(String input) {
        if (!hasProperCustomSeparator(input)) {
            throw new RuntimeException("커스텀 구분자의 형식이 올바르지 않습니다.");
        }

        return extractCustomSeparator(input);
    }

    private List<Integer> convertStringNumbersIntoList(String stringNumbers, String regex) {
        List<Integer> results = new ArrayList<>();

        String[] stringNumberArray = stringNumbers.split(regex);
        logger.info("문자열로부터 변환된 리스트: " + Arrays.toString(stringNumberArray));
        for (String stringNumber : stringNumberArray) {
            validateStringNumber(stringNumber, regex);

            results.add(Integer.parseInt(stringNumber));
        }

        return Collections.unmodifiableList(results);
    }

    private void validateStringNumber(String stringNumber, String regex) {
        if (!isIntegerString(stringNumber)) {
            throw new RuntimeException(String.format("숫자 이외의 값을 전달할 수 없습니다: %s", stringNumber));
        }

        if (!regex.contains(".") && isFloatNumber(stringNumber)) {
            throw new RuntimeException(String.format("실수를 전달할 수 없습니다: %s", stringNumber));
        }

        if (isNegative(Integer.parseInt(stringNumber))) {
            throw new RuntimeException(String.format("음수를 전달할 수 없습니다: %s", stringNumber));
        }
    }

    private boolean hasProperCustomSeparator(String input) {
        if (!isContainsStarterAndTerminator(input)) {
            return false;
        }

        String customSeparator = extractCustomSeparator(input);
        return isLegalCustomSeparator(customSeparator);
    }

    private static boolean isContainsStarterAndTerminator(String input) {
        int startIndex = input.indexOf(CUSTOM_SEPARATOR_STARTER);
        int endIndex = input.indexOf(CUSTOM_SEPARATOR_TERMINATOR);

        return isNotNegative(startIndex) && isNotNegative(endIndex);
    }

    private static String extractCustomSeparator(String input) {
        return input.substring(input.indexOf(CUSTOM_SEPARATOR_STARTER) + CUSTOM_SEPARATOR_STARTER.length(), input.indexOf(CUSTOM_SEPARATOR_TERMINATOR));
    }

    private static boolean isLegalCustomSeparator(String customSeparator) {
        return customSeparator != null && !customSeparator.isEmpty() && !isContainsDigit(customSeparator);
    }

    private static String createRegexByCustomSeparator(String customSeparator) {
        StringBuilder regexBuilder = new StringBuilder();

        for (String basicSeparator : BASIC_SEPARATORS) {
            regexBuilder.append(basicSeparator)
                    .append("|");
        }

        return regexBuilder.append(customSeparator)
                .toString();
    }

    private static String createBasicRegex(Set<String> basicSeparators) {
        StringBuilder regexBuilder = new StringBuilder();

        for (String basicSeparator : basicSeparators) {
            regexBuilder.append(basicSeparator)
                    .append("|");
        }

        return regexBuilder.delete(regexBuilder.length() - 1, regexBuilder.length())
                .toString();
    }

    private static boolean isStartsWithCustomSeparatorStarter(String input) {
        return input.startsWith(CUSTOM_SEPARATOR_STARTER);
    }

    static class SafetyCustomSeparatorMapper {

        private static final Set<Character> REGEX_META_CHARACTERS = Set.of('\"', '.', '^', '$', '*', '+', '?', '{', '}', '[', ']', '(', ')', '|');
        private final String customSeparator;
        private final String extractedInput;

        public SafetyCustomSeparatorMapper(String customSeparator, String extractedInput) {
            this.customSeparator = customSeparator;
            this.extractedInput = extractedInput;
        }

        /**
         * customSeparator가 메타문자일 경우, 이스케이프 문자가 더해진 customSeparator를 반환한다. <br>
         * 메타문자가 아닐 경우, 생성자로 전달받은 customSeparator를 그대로 반환한다.
         *
         * @return 안전하게 변환된 customSeparator
         */
        public String getSafetyCustomSeparator() {
            StringBuilder safetyCustomSeparatorBuilder = new StringBuilder();

            for (char word : customSeparator.toCharArray()) {
                if (REGEX_META_CHARACTERS.contains(word)) {
                    safetyCustomSeparatorBuilder.append(addEscape(word));
                } else {
                    safetyCustomSeparatorBuilder.append(word);
                }
            }

            return safetyCustomSeparatorBuilder.toString();
        }

        /**
         * customSeparator가 메타문자일 경우, 문자열 내 모든 customSeparator를 안전하게 변경한 extractedInput을 반환한다. <br>
         * customSeparator가 메타문자가 아닐 경우, 생성자로 전달받은 extractedInput을 그대로 반환한다.
         *
         * @return 안전하게 변환된 extractedInput
         */
        public String getSafetyExtractedInput() {
            if (isMetaCharacter(customSeparator)) {
                StringBuilder safetyInputBuilder = new StringBuilder();
                String extractedInputCopy = extractedInput;

                while (extractedInputCopy.contains(customSeparator)) {
                    int indexOfCustomSeparator = findIndexOfCustomSeparator(customSeparator, extractedInputCopy);

                    safetyInputBuilder.append(extractedInputCopy, 0, indexOfCustomSeparator)
                            .append(getSafetyCustomSeparator());

                    extractedInputCopy = extractedInputCopy.substring(indexOfCustomSeparator + customSeparator.length());
                }

                return safetyInputBuilder.toString();
            }

            return extractedInput;
        }

        private boolean isMetaCharacter(String customSeparator) {
            return REGEX_META_CHARACTERS.contains(customSeparator);
        }

        private int findIndexOfCustomSeparator(String customSeparator, String extractedInput) {
            return extractedInput.indexOf(customSeparator);
        }
    }

    enum Operator {
        ADD {
            @Override
            int operate(int leftOperand, int rightOperand) {
                Operator.validateOutOfRangeIfAdd(leftOperand, rightOperand);

                return leftOperand + rightOperand;
            }
        },
        SUBTRACT {
            @Override
            int operate(int leftOperand, int rightOperand) {
                Operator.validateOutOfRangeIfAdd(leftOperand, -rightOperand);

                return leftOperand - rightOperand;
            }
        },
        MULTIPLY {
            @Override
            int operate(int leftOperand, int rightOperand) {
                Operator.validateOutOfRangeIfMultiply(leftOperand, rightOperand);

                return leftOperand * rightOperand;
            }
        },
        DIVIDE {
            @Override
            int operate(int dividend, int divisor) {
                if (isZero(divisor)) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }

                return dividend / divisor;
            }
        };

        abstract int operate(int leftOperand, int rightOperand);

        private static void validateOutOfRangeIfAdd(int a, int b) {
            if (isWithoutIntRange((long) a + (long) b)) {
                throw new IllegalArgumentException(String.format("(%d)와(과) (%d) 연산시 오버플로우 혹은 언더플로우가 발생합니다.", a, b));
            }
        }

        private static void validateOutOfRangeIfMultiply(int a, int b) {
            if (isWithoutIntRange((long) a * (long) b)) {
                throw new IllegalArgumentException(String.format("(%d)와(과) (%d) 연산시 오버플로우 혹은 언더플로우가 발생합니다.", a, b));
            }
        }

        private static boolean isWithoutIntRange(long number) {
            return number < Integer.MIN_VALUE || number > Integer.MAX_VALUE;
        }
    }
}
