package simpleCalculator.model;

public class Calculator {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private int num1;
    private int num2;

    private boolean checkHowManyInput(String[] inputList) {
        return inputList.length != TWO;
    }

    private String[] splitList(String input) {
        return input.split(",");
    }

    private int convertToInt(String input) {
        int number = Integer.parseInt(input);
        if (number < ZERO) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private int[] convertToIntList(String[] inputList) {
        try {
            int[] numberList = new int[inputList.length];
            for (int i = ZERO; i < inputList.length; i++) {
                numberList[i] = convertToInt(inputList[i]);
            }
            return numberList;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 다른 형식이 포함되어 있습니다.");
        }
    }

    public void setNumber(String input) {
        String[] inputList = splitList(input);
        if (checkHowManyInput(inputList)) {
            throw new RuntimeException("2개의 숫자를 입력해주세요.");
        }
        int[] numbers = convertToIntList(inputList);
        this.num1 = numbers[ZERO];
        this.num2 = numbers[ONE];
    }

    public int addNumbers() {
        return num1 + num2;
    }

    public int subNumbers() {
        return num1 - num2;
    }

    public int divideNumbers() {
        if (num2 == 0) {
            throw new RuntimeException("0으로 나누기는 불가합니다.");
        }
        return num1 / num2;
    }

    public int multipleNumbers() {
        return num1 * num2;
    }
}
