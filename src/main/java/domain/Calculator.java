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

    static String[] numArr=null;

    private String[] splitString(String s){
        numArr= s.split("[,|:]");
        return numArr;
    }

    private String findCustomSplit(String s){
        if (s.contains(SPLIT_CHAR1)&& s.contains(SPLIT_CHAR2)){
            customSplitString = s.substring(s.indexOf(SPLIT_CHAR1), s.indexOf(SPLIT_CHAR2));
        }
        return customSplitString;
    }

    private String[] splitCustomSplit(String s){
        numArr=s.split(s);
        return numArr;
    }

    private static int getSum(String[] str){
        int sum=0;
        for (String num:str){
            sum+=Integer.parseInt(num);
        }
        return sum;
    }


    public void StringCalculator(String s){
        if (s.contains(",")||s.contains(":")){
            numArr=splitString(s);
        }
        else{
            numArr=splitCustomSplit(findCustomSplit(s));
        }
    }

    public static int getAnswer(){
        return getSum(numArr);
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
        result=a/b;
        return result;
    }

}
