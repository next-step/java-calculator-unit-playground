public class Calculator {

    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiple(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int stringAdd(String input) {
        if (input.isBlank()) {
            throw new RuntimeException();
        }
        CustomStringExtractor extractor = new CustomStringExtractor();
        String[] strList = extractor.extractString(input);

        int result = 0;
        for (String str : strList) {
            try {
                int num = Integer.parseInt(str);
                if (num < 0) {
                    throw new RuntimeException();
                }
                result += num;
            } catch (Exception e) {
                throw new RuntimeException("잘못된 문자열입니다. string: " + str);
            }
        }
        return result;
    }
}
