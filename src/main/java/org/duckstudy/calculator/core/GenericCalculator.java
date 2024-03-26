package org.duckstudy.calculator.core;

import java.math.BigDecimal;
import java.util.function.Function;

/*
    제네릭 계산기 : 정수, 소수점 계산을 허용한다.
    - BigDecimal 타입으로 계산한다.
    - Function의 toType() 메서드로 결과값을 입력값의 타입(T)로 형변환한다.
 */
public class GenericCalculator<T extends Number> implements Calculator<T>{
    private BigDecimal result;
    private Function<BigDecimal, T> toType;

    public GenericCalculator(Function<BigDecimal, T> toType) {
        this.toType = toType;
        reset();
    }

    @Override
    public T add(T value) {
        result = result.add(new BigDecimal(value.toString()));
        return toType.apply(result);
    }

    @Override
    public T subtract(T value) {
        result = result.subtract(new BigDecimal(value.toString()));
        return toType.apply(result);
    }

    @Override
    public T multiply(T value) {
        result = result.multiply(new BigDecimal(value.toString()));
        return toType.apply(result);
    }

    @Override
    public T divide(T value) throws ArithmeticException {
        result = result.divide(new BigDecimal(value.toString()));
        return toType.apply(result);
    }

    @Override
    public void reset() {
        result = BigDecimal.ZERO;
    }

//    public static void main(String[] args){
//        GenericCalculator<Integer> gc = new GenericCalculator<>(BigDecimal::intValue);
//        Number result = gc.add(3);
//        System.out.println(result);
//
//        GenericCalculator<Double> gc2 = new GenericCalculator<>(BigDecimal::doubleValue);
//        gc2.add(3.4);
//        Number result2 = gc2.add(4.4);
//        System.out.println(result2);
//    }
}
