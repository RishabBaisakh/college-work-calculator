package com.learning.calculator;

public class CalculatorState {
    private Boolean operandOnePresent;
    private Boolean operandTwoPresent;
    private Boolean operatorPresent;

    public CalculatorState(){
        resetState(false, false, false);
    }

    public Boolean canCalculate() {
        return getOperandOnePresent() && getOperandTwoPresent() && getOperatorPresent();
    }

    public Boolean getOperandOnePresent() {
        return operandOnePresent;
    }

    public Boolean getOperandTwoPresent() {
        return operandTwoPresent;
    }

    public Boolean getOperatorPresent() {
        return operatorPresent;
    }

    public void resetState(Boolean operandOnePresent, Boolean operandTwoPresent, Boolean operatorPresent) {
        this.operandOnePresent = operandOnePresent;
        this.operandTwoPresent = operandTwoPresent;
        this.operatorPresent = operatorPresent;
    }
}
