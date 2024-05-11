package stringCalcculator.model;

public class StringCalculator {

    private static final String DEFAULTS = ",|:";
    public boolean checkBlank(String input){
        return input == null || input.isEmpty();
    }

    public String[] splitInput(String input){
        if (input.startsWith("//")) {
            return splitByCustom(input);
        }
        return input.split(DEFAULTS);
    }

    public String[] splitByCustom(String input){
        String[] separates = input.split("\n", 2);
        String custom = separates[0].substring(2);
        return separates[1].split(custom);
    }

    public int[] listToInt(String[] inputList){
        try {
            int[] numberList = new int[inputList.length];
            for (int i = 0; i < inputList.length; i++) {
                numberList[i] = convertToInt(inputList[i]);
            }
            return numberList;
        } catch (NumberFormatException e){
            throw new RuntimeException("숫자가 아닌 다른 형식이 포함되었습니다.");
        }
    }

    public int convertToInt(String input){
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    public int sum(int[] inputList){
        int total = 0;
        for(int number : inputList){
            total += number;
        }
        return total;
    }

    public int add(String input){
        if(checkBlank(input)){
            return 0;
        }
        return sum(listToInt(splitInput(input)));
    }
}
