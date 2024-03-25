package org.duckstudy.calculator.core;
public interface Calculator {
    int add(int value);

    int subtract(int value);

    int multiply(int value);

    int divide(int value) throws ArithmeticException;

    void reset();

}
