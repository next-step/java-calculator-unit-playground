package org.duckstudy.calculator.core;

import java.math.BigDecimal;
import java.util.function.Function;

public class GenericCalculator<T extends Number> implements Calculator<T> {
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
}
