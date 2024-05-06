package domain;

public class SplitString {

    private static final int INITIAL_NUMBER = 0;
    private static final String START_STRING = "//";
    private static final String END_STRING = "\n";
    private static int START_INT_NUM = 2;
    private static int END_INT_NUM = 3;
    private static int START_NUM = 5;

    public static int[] intArr;
    public String[] strArr;

    public int[] splitStr(String str) {
        splitException(str);
        intArr = new int[strArr.length];
        return intArr;
    }

    private void splitException(String str) {
        if (str.startsWith(START_STRING) && str.endsWith(END_STRING)) {
            String basicSplit = str.substring(START_INT_NUM, END_INT_NUM);
            strArr = str.substring(START_NUM).split(basicSplit);
            Exception(strArr);
        }
    }

    private static void Exception(String[] strArr) {
        for (int i = INITIAL_NUMBER; i < strArr.length; i++) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
                validateMinus(intArr, i);
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
    }

    private static void validateMinus(int[] intArr, int i) {
        if (intArr[i] < 0) {
            throw new IllegalArgumentException();
        }
    }
}
