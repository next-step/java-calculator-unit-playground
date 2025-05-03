public class StringCalculateClass {
    //case1 : , 또는 ;을 구분자로 가지는 경우
    //case2 : //\n 사이 문자를 구분자로 가지는 경우
    //1. 입력 받기 -> 메서드
    //2. 문자열을 구분한 후 -> 정수화 후 더하기
    //3. 결과값 출력
    //4. 예외 처리
    public int combineString(String input){

        //없는 경우
        if (input.isEmpty() || input == null){
            return 0;
        }
        //커스텀 문자 사용하는 경우
        if (input.startsWith("//")){
            String[] splitString = (input.substring(5)).split(String.valueOf(input.charAt(2)));
            return sum(splitString);
        }
        //; , 을 사용하는 경우
        if (input.contains(";") || input.contains(",")){
            String[] splitString = input.split(";|,");
            return sum(splitString);
        }

        //예외처리
        try {
            int num = Integer.parseInt(input);
            if (num < 0) {
                throw new RuntimeException("음수가 포함되었습니다");
            }
            return num;
        }
        catch(NumberFormatException e){
            throw new RuntimeException("숫자 이외의 값이 작성되었습니다");
        }

    }
    private int sum(String[] split) {
        int sum = 0;
        for (String s : split) {
            int i = Integer.parseInt(s);
            sum += i;
        }
        return sum;
    }

}
