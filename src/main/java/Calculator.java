public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b){
        return a - b;
    }
    int multiply(int a, int b){
        return a * b;
    }
    int divide(int a, int b){
        return a / b;
    }

    public int calculateString(String input) {
        if (input == null | input.isEmpty()) {
            return 0;
        }

        String separator = "[,:]";//정규표현식. split()메소드에서 사용된다. '[]안의 문자중 하나와 일치'라는 의미를 갖는다.
        String numbersStr = input;

        if (input.substring(0, 2).equals("//")) {
            int slashStartIndex = input.indexOf("//");
            int newLineStartIndex = input.indexOf("/n");

            if (newLineStartIndex != -1) {
                String customSeparator = input.substring(slashStartIndex + 2, newLineStartIndex);
                separator = "[,:" + customSeparator + "]";
                numbersStr = input.substring(newLineStartIndex + 1);//개행문자는 하나의 문자로 취급.
            }
        }

            String[] numbers = numbersStr.split(separator);

            int sum = 0;
            for (String number : numbers) {
                if (!number.isEmpty()) {
                    int value = Integer.parseInt(number);//String 배열에 있는 numbers를 하나씩 int형으로 변환
                    if (value < 0) {
                        throw new RuntimeException("음수는 사용할 수 없습니다 : " + value);
                    }
                    sum += value;
                }
            }
            return sum;
    }
}

