package domain;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String BASIC_DELIMITER=",|:";
    private static final String FIRST_STRING="//";
    private static final String LAST_STRING="\n";
    private String customDelimiter="";
    private final String input;

    public StringCalculator(String input){
        this.input=input;
    }

    public boolean containCustomSplitStr(){
        return input.startsWith(FIRST_STRING)&&input.contains(LAST_STRING);
    }

    private String findCustomSplit(){
        customDelimiter=input.substring(input.indexOf(FIRST_STRING)+2,input.indexOf(LAST_STRING));
        return customDelimiter;
    }

    public List<String> splitCustom(){
        findCustomSplit();
        String splitStr=input.substring(input.indexOf(LAST_STRING)+1);
        return Arrays.asList(splitStr.split(customDelimiter));
    }

    public List<String> splitBasic(){
        return Arrays.asList(input.split(BASIC_DELIMITER));
    }

    public List<Integer> changeStrToInt(List<String> strList){
        try{
            List<Integer> numbers=new ArrayList<>();
            for (String string: strList){
                numbers.add(Integer.parseInt(string));
            }
            return numbers;
        } catch (NumberFormatException exception){
            throw new RuntimeException("숫자를 입력해주세요.");
        }
    }

    public int getSum(List<Integer> numList){
        int sum=0;
        for (int num: numList){
            if(num<0){
               throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            sum+=num;
        }
        return sum;
    }

    public void checkBlankInput() throws NoSuchObjectException{
        if (input.isEmpty()){
            throw new NoSuchObjectException("공백은 입력할 수 없습니다.");
        }
    }
}
