# java-calculator

## 기능 요구사항

- 인자 2개를 받아 사칙연산을 할 수 있는 계산기를 구현한다.
- 사칙연산과 매칭되는 4개의 메서드를 제공한다.
- 계산된 결과는 정수를 반환한다.

## 새로운 프로그래밍 요구사항

- 메인 메서드는 만들지 않는다.

# 3단계 - 문자열 계산기 구현

## 기능 요구사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 1차 시도

- 요구 사항 하나씩 맞추면서 테스트 코드를 작성하면서 calculate 메서드 안에 모든 로직이 들어가있음
- 얼핏보면 calculate 메서드가 코드량이 많지 않으니 한 메서드 안에 다 들어가도 되지 않을까 하지만, 라인이 늘어나면 읽기 어려운 코드가 될거 같다 생각됨
- calculate 메서드는 단순히 문자열만 계산하는 역할로만 두고 싶고, 유효성 검사 및 구분자 변동은 생성자에서 바꾸는 방향으로 변경

```java
public class StringCalculator {

    private List<String> delimiter = Arrays.asList(":", ",");

    public int calculate(String str) {
        String regex = "^//.+\n.*";
        if (str.matches(regex)) {
            delimiter = List.of("(" + str.substring(2, str.indexOf("\n")) + ")");
            str = str.substring(str.indexOf("\n") + 1);
        }

        final String[] strings = str.split(String.join("|", delimiter));

        if (strings.length == 0) {
            return 0;
        }

        return Arrays.stream(strings)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
```

## 2차 시도

- 생성자에서 식을 받아 구분자 확인, 피연산자 생성, 유효성 체크를 함으로써 calculate 메서드는 단순히 더하기만 하면 된다
- 어찌보면 메서드가 많이 나눠져 코드가 길어져 안 좋아 보일 수도 있겠지만 메서드들마다 기능을 나누어 가독성은 좋아지지 않았을까 생각한다

```java
public class StringCalculator {

    private List<String> delimiter = Arrays.asList(":", ",");

    private String strings;
    private String[] operands;

    public StringCalculator(final String expression) {
        updateDelimiter(expression);
        makeOperands();
        checkValidate();
    }

    private void updateDelimiter(final String expression) {
        if (canChangeNewDelimiter(expression)) {
            delimiter = List.of("(" + expression.substring(2, expression.indexOf("\n")) + ")");
            strings = expression.substring(expression.indexOf("\n") + 1);
        } else {
            strings = expression; // 원래 if 문에 return으로 끝내고 else를 주는 편인데, 이 편이 좀 더 가독성이 좋아보여 else로 해봄
        }
    }

    private boolean canChangeNewDelimiter(String expression) {
        final String regex = "^//.+\n.*";
        return expression.matches(regex);
    }

    private void makeOperands() {
        operands = strings.split(String.join("|", delimiter));
    }

    private void checkValidate() {
        try {
            if (Arrays.stream(operands).anyMatch(s -> s.matches("[\\D]*"))) {
                throw new RuntimeException("문자열은 들어올 수 없습니다");
            }

            if (Arrays.stream(operands).anyMatch(s -> Integer.parseInt(s) < 0)) {
                throw new RuntimeException("음수는 들어올 수 없습니다");
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException("유효하지 않은 포맷입니다");
        }
    }

    public int calculate() {

        if (operands.length == 0) {
            return 0;
        }

        return Arrays.stream(operands)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
```

# 4단계 - 리팩터링

- AssertJ 사용해보기

- 사용해보면서 assertThatThrowBy 메서드에서 hasMessage를 사용했더니, 기존 assertThrows로 발견 못했던 에러를 발견해서 테스트 케이스를 좀 더 수정해볼 수 있었다.
