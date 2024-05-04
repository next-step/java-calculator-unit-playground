package domain;

public class SplitString {

    private final String DISTINCTION = ":|@|,";
    private int i;
    private final int INITIAL_NUMBER = 0;
    public int[] intArr;

    public void splitStr(String str) {
        String[] strArr = str.split(DISTINCTION);
        int[] intArr = new int[strArr.length];
        Exception(strArr, intArr);
    }

    private void Exception(String[] strArr, int[] intArr) {
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
