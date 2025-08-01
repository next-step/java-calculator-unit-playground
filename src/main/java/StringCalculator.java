import java.util.regex.Pattern;

public class StringCalculator {

    public String validateInput(String input){
        if(input == null) throw new RuntimeException("null은 허용되지 않습니다.");
        return input;
    }

    public int getDelimiter(String input) {
        if(input.isEmpty()) return -2; //문자열이 빈 경우

        if (input.startsWith("//")) {
            int delimiterIdx = input.indexOf("\n");
            if (delimiterIdx == -1) throw new RuntimeException("잘못된 커스텀 구분자 형식입니다.");
            return delimiterIdx;
        }

        return -1; //기본 구분자대로 문자열을 나눔
    }

    private String[] splitInput(String checkedInput, int idx){
        if(idx == -1){
            String delimiter = "[,:]";
            return checkedInput.split(delimiter);
        }
        else if(idx == -2){
            return new String[0]; //빈 문자열인 경우
        }
        else{
            String delimiter = checkedInput.substring(2, idx);
            String regex = Pattern.quote(delimiter);
            return checkedInput.substring(idx + 1).split(regex);
        }
    }

    public int sum(String[] strings){
        if(strings.length == 0) return 0;

        int sum = 0;

        for(var n : strings){
            if(n.isEmpty()) throw new RuntimeException("빈 문자열입니다.");

            int num = validateNumbers(n);

            if(sum > Integer.MAX_VALUE - num || sum < Integer.MIN_VALUE + num) throw new RuntimeException("int 범위를 벗어났습니다.");

            sum += num;
        }
        return sum;
    }

    private int validateNumbers(String n){
        int num;
        try{
            num = Integer.parseInt(n);
            if(num < 0) throw new RuntimeException("음수는 입력이 불가합니다.");
        }
        catch(NumberFormatException msg){
            throw new RuntimeException("int 값을 벗어났거나 잘못된 숫자 형식입니다.");
        }
        return num;
    }

    public int calculate(String input){
        String checkedInput = validateInput(input);
        int idx = getDelimiter(checkedInput);
        String[] strings = splitInput(checkedInput, idx);
        return sum(strings);
    }
}
