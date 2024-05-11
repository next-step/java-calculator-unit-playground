package domain;

import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.lang.String;


public class Calculator {
    private static int result;
    private static final String SPLIT_CHAR1="//";
    private static final String SPLIT_CHAR2="|n";
    private static String customSplitString="";

    static String[] strArr=null;
    static int[] numArr=null;

    private String[] splitString(String s){
        strArr= s.split("[,|:]");
        return strArr;
    }

    private String findCustomSplit(String s){
        if (s.contains(SPLIT_CHAR1)&& s.contains(SPLIT_CHAR2)){
            customSplitString = s.substring(s.indexOf(SPLIT_CHAR1)+2, s.indexOf(SPLIT_CHAR2));
        }
        return customSplitString;
    }

    private String[] splitCustomSplit(String s){
        customSplitString=findCustomSplit(s);
        s=s.substring(s.indexOf(customSplitString)+3);
        strArr=s.split(customSplitString);
        return strArr;
    }

    public int[] stringToInteger(String[] s){
        try{
            for (int i=0;i< strArr.length;i++){
                numArr[i]=Integer.parseInt(strArr[i]);
            }
        } catch (RuntimeException runtimeException){
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        return numArr;
    }

    private int getSum(String[] strArr){
        numArr=stringToInteger(strArr);
        int sum=0;
        for (int num:numArr){
            if (num<0){
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            sum+=num;
        }
        return sum;
    }

    public int StringCalculator(String s) {
        try {
            blankString(s);
        } catch (NoSuchObjectException e) {
            throw new RuntimeException();
        }
        if (s.contains(",")||s.contains(":")){
            strArr=splitString(s);
        }
        else{
            customSplitString=findCustomSplit(s);
            strArr=splitCustomSplit(s);
        }
        return getSum(strArr);
    }

    public void blankString(String s) throws NoSuchObjectException{
        if (s.isEmpty()){
            throw new NoSuchObjectException("공백은 입력할 수 없습니다.");
        }
    }

    public int[] getNumArr(){
        return numArr;
    }


    public int add(int a, int b){
        result=a+b;
        return result;
    }

    public int subtract(int a, int b){
        result=a-b;
        return result;
    }

    public int multiply(int a, int b){
        result=a*b;
        return result;
    }

    public int divide(int a, int b){
        if (b==0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        result=a/b;
        return result;
    }

}
