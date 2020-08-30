package com.learning.calculator;

public class BasicCalculator {

    public static Float calculate(Float operandOne, Float operandTwo, String operator){
        switch(operator){
            case "+":
                return operandOne + operandTwo;
            case "-":
                return operandOne - operandTwo;
            case "x":
                return operandOne * operandTwo;
            case "÷":
                return operandOne / operandTwo;
        }

        return null;
    }
}
