package simpleCalculator.model;

public class StringCalculator {

    private static final String SEPARATOR_DEFAULTS = ",|:";
    private static final int ZERO = 0;

    private boolean checkBlank(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitInput(String input) {
        if (input.startsWith("//")) {
            return splitByCustom(input);
        }
        return input.split(SEPARATOR_DEFAULTS);
    }

    private String[] splitByCustom(String input) {
        String[] separates = input.split("\n", 2);
        String custom = separates[ZERO].substring(2);
        return separates[1].split(custom);
    }

    private int[] listToInt(String[] inputList) {
        try {
            int[] numberList = new int[inputList.length];
            for (int i = ZERO; i < inputList.length; i++) {
                numberList[i] = convertToInt(inputList[i]);
            }
            return numberList;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 다른 형식이 포함되었습니다.");
        }
    }

    private int convertToInt(String input) {
        int number = Integer.parseInt(input);
        if (number < ZERO) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private int sum(int[] inputList) {
        int total = ZERO;
        for (int number : inputList) {
            total += number;
        }
        return total;
    }

    public int add(String input) {
        if (checkBlank(input)) {
            return ZERO;
        }
        return sum(listToInt(splitInput(input)));
    }
}
