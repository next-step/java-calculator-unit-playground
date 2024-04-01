package org.duckstudy.calculator.core;

public interface Calculator<T, R> {
    R add(T value);

    R subtract(T value);

    R multiply(T value);

    R divide(T value);

    void reset();

}
