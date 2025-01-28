import javax.management.RuntimeErrorException;

public class Calculator {
    public int plus(int a, int b){
        if((a>0 && b>0) && a>Integer.MAX_VALUE-b)   // 둘 다 양수
            throw new RuntimeException("plus overflow");
        if((a<0 && b<0) && a<Integer.MIN_VALUE-b)   // 둘 다 음수
            throw new RuntimeException("plus overflow");

        return a+b;
    }

    public int minus(int a, int b){
        if((a>0 && b<0) && a>Integer.MAX_VALUE+b)
            throw new RuntimeException("minus overflow");
        if((a<0 && b>0) && a<Integer.MIN_VALUE+b)
            throw new RuntimeException("minus overflow");

        return a-b;
    }

    public int multiply(int a, int b){
        if(a==0 || b==0)    return 0;   // overflow 체크 대비
        if(a>Integer.MAX_VALUE/b || a<Integer.MIN_VALUE/b)
            throw new RuntimeException("multiply overflow");

        return a*b;
    }

    public int divide(int a, int div){
        if(div==0)
            throw new RuntimeException("div by 0");
        if(a==Integer.MIN_VALUE && div==-1)
            throw new RuntimeException("divide overflow");

        return a/div;
    }
    
}
