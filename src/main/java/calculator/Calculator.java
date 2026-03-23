package calculator;

public class Calculator {//shift f6을 누르면서 이름을 바꾸면 파일명도 같이 변해서 그냥 적용이 가능하다
    int add(int num1, int num2){
        return num1+num2;
    }
    int subtract(int num1, int num2){
        return num1-num2;
    }
    int multiply(int num1, int num2){
        return num1*num2;
    }
    int divide(int num1, int num2){
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
    int splitAdd(String string){
        String regex = ":|,"; //구분자 선언
        String targetString = string; //최종적으로 split할때 넣을 문자열 선언

        if (string.startsWith("//")) { //string 시작할때 커스텀 구분자 있는지 확인
            int indexStart = string.indexOf("//");
            int indexEnd = string.indexOf("\n");

            String customSplitter = string.substring(indexStart + 2, indexEnd); //커스텀 구분자 선언
            regex = ":|,|" + customSplitter; //기존 구분자 모음에 커스텀 구분자 추가
            targetString = string.substring(indexEnd + 1); //앞에 있는 비문자열 부분 자르기
        }

        String[] tokens = targetString.split(regex); // 구분자를 기준으로 문자열을 자른 최종 문자열 배열 선언 및 대입
        int sum = 0; //초기화

        for (int i = 0; i < tokens.length; i++) {
            try {
                int number = Integer.parseInt(tokens[i]); //일단 정수형으로 변환 시도

                if (number < 0) {
                    throw new RuntimeException("음수는 전달할 수 없습니다."); //음수인 경우
                }

                sum += number; //아닌경우 더하기

            } catch (NumberFormatException e) { //정수형 반환이 불가능한 경우(문자형 같은 경우)
                throw new RuntimeException("숫자 이외의 값은 전달할 수 없습니다.");
            }
        }

        return sum;
    }
}
