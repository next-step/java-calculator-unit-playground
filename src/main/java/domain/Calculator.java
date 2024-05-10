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
