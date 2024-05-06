package view;

public class OutputView {
    private final String DISTINCTION_FRONT = "//";
    private final String DISTINCTION_BACK = "\n";
    private final int INITIAL_NUMBER = 0;
    private final int START_NUM = 2;
    private final int NEXT_START_NUM = 1;

    private int i;
    private int[] intArr;

    public String splitStr(String str) {
        if (str.startsWith(DISTINCTION_FRONT) && str.contains(DISTINCTION_BACK)) {
            String extract = str.substring(START_NUM, str.indexOf(DISTINCTION_BACK));
            String[] strArr = str.substring(str.indexOf(DISTINCTION_BACK) + NEXT_START_NUM).split(extract);
            intArr = new int[strArr.length];
            Exception(strArr);
        }
        return str;
    }

    private void Exception(String[] strArr) {
        for (i = INITIAL_NUMBER; i < strArr.length; i++) {
            try {
                intArr[i] = Integer.parseInt(strArr[i]);
                if (intArr[i] < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
        }
    }
}
