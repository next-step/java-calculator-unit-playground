package org.duckstudy.calculator.core;
public interface Calculator<T extends Number> {
    T add(T value);

    T subtract(T value);

    T multiply(T value);

    T divide(T value) throws ArithmeticException;

    void reset();

}
