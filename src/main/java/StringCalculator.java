/*
input을 받고 빈문자열인지 null인지 체크
구분자 체크 -> 구분자 예외 체크
구분자 대로 문자열 계산기 구현
 */

public class StringCalculator {
    public String checkInput(String input){
        if(input == null || input.equals(" ")) throw new RuntimeException("");
        return input;
    }

    public String[] checkDelimiter(String input) {
        String checkedInput = checkInput(input);
        String delimiter = "[,:]";
        if (checkedInput.startsWith("//")) {
            int idx = checkedInput.indexOf("\n");
            if (idx == -1) throw new RuntimeException("");
            delimiter = checkedInput.substring(2, idx);
            return checkedInput.substring(idx + 1).split(delimiter);
        }
        return checkedInput.split(delimiter);
    }

    public int sum(String input){
        String [] strings = checkDelimiter(input);
        int sum = 0;
        for(var n : strings){
            if(n.isEmpty()) throw new RuntimeException("");
            try {
                int num = Integer.parseInt(n);
                if(num < 0) throw new RuntimeException("");
                sum += num;
            }
            catch(NumberFormatException msg){
                throw new RuntimeException("");
            }
        }
        return sum;
    }
}
