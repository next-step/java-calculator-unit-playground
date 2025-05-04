//문자열을 구분자로 나누는 클래스
public class StringParser {
    //기본 구분자
    public static final String DEFAULT_SEPARATOR = "[,:]";

    public static String[] parse(String input) {
        if (input == null | input.isEmpty()) {
            return new String[0];//입력이 비어있으면 빈 배열을 반환
        }
        String separator = DEFAULT_SEPARATOR;
        String numbersStr = input;

        if(input.startsWith("//")){
            int slashStartIndex = input.indexOf("//");
            int newLineStartIndex = input.indexOf("\n");

            if(newLineStartIndex != -1){
                String customSeparator = input.substring(slashStartIndex + 2, newLineStartIndex);
                separator = "[,:" + customSeparator + "]";
                numbersStr = input.substring(newLineStartIndex + 1);
            }
        }
        //구분자로 분리된 number 배열을 반환
        return numbersStr.split(separator);
    }
}
