package view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String DISTINCTION_FRONT = "//";
    private static final String DISTINCTION_BACK = "\n";
    private static final int FOR_DISTINCTION_NUM = 1;

    private ArrayList<Integer> parsedValues = new ArrayList<>();

    public List<Integer> parseString(String str) {

        if (str.startsWith(DISTINCTION_FRONT) && str.contains(DISTINCTION_BACK)) {
            String separator = str.substring(DISTINCTION_FRONT.length(), DISTINCTION_FRONT.length() + FOR_DISTINCTION_NUM);
            String numbersList = str.substring(str.indexOf(DISTINCTION_BACK) + FOR_DISTINCTION_NUM);
            String[] numbersArray = numbersList.split(separator);

            for (String num : numbersArray) {
                try {
                    int parsedNum = Integer.parseInt(num.trim());
                    parsedValues.add(parsedNum);
                } catch (NumberFormatException e) {
                }
            }
        }
        return parsedValues;
    }
}
