package com.learning.calculator;

public class BasicCalculator {

    public Float calculate(Float operandOne, Float operandTwo, MathOperator operator){
        switch(operator){
            case ADD:
                return operandOne + operandTwo;
            case SUBTRACT:
                return operandOne - operandTwo;
            case MULTIPLY:
                return operandOne * operandTwo;
            case DIVIDE:
                return operandOne / operandTwo;
        }

        return null;
    }
}
