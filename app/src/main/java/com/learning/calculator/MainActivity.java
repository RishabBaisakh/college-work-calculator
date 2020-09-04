package com.learning.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface {

    TextView displayTextView;
    TextView operationTextView;
    Button clickedButton;
    CalculatorState calculatorState;
    AlertDialog.Builder warningDialogBuilder;
    String stream = "";
    Float operandOne;
    Float operandTwo;
    String operator = "";
    Float result;

    String operandOneText;
    String operandTwoText;
    String operatorText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.main_displayTextView);
        operationTextView = findViewById(R.id.main_operationTextView);
        calculatorState = new CalculatorState();
    }

    public void numberInputGotClicked(View view) {
        clickedButton = (Button) view;
        String inputNumber = clickedButton.getText().toString();
        stream += inputNumber;

        if (!calculatorState.getOperatorPresent()) {
            operandOne = Float.parseFloat(stream);
            calculatorState.resetState(true, false, false);
        } else {
            operandTwo = Float.parseFloat(stream);
            calculatorState.resetState(true, true, true);
        }
        this.updateViews(stream);
    }

    public void operatorsClicked(View view) {
        clickedButton = (Button) view;

        if (!calculatorState.getOperatorPresent()) {
            operator = clickedButton.getText().toString();
            stream = "";
            calculatorState.resetState(true, false, true);
            this.updateViews(operator);
        } else
            this.showWarningAlertDialog("Warning!", "Can't perform this operation!");
    }

    public void evaluateButtonGotClicked(View view) {
        clickedButton = (Button) view;

        if (calculatorState.canCalculate()) {
            this.result = BasicCalculator.calculate(operandOne, operandTwo, operator);
            assert this.result != null;
            this.updateViews(this.result.toString());
            this.operandOne = this.result;
            this.operandTwo = null;
            this.result = null;
            this.operator = "";
            calculatorState.resetState(true, false, false);
        } else
            this.showWarningAlertDialog("Warning", "Can't evaluate now!");
    }

    public void resetButtonGotClicked(View view) {
        displayTextView.setText("0");
        calculatorState.resetState(false, false, false);
    }


    private void showWarningAlertDialog(String warningTitle, String warningMessage) {
        warningDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        warningDialogBuilder.setTitle(warningTitle)
                .setMessage(warningMessage)
                .setNegativeButton("Cancel", null);

        AlertDialog warningAlertDialog = warningDialogBuilder.create();
        warningAlertDialog.show();
    }

    private void updateViews(String displayText) {
        operandOneText = (calculatorState.getOperandOnePresent()) ? this.operandOne.toString() : "";
        operandTwoText = (calculatorState.getOperandTwoPresent()) ? this.operandTwo.toString() : "";
        operatorText = this.operator;

        displayTextView.setText(displayText);
        operationTextView.setText(operandOneText + operatorText + operandTwoText);
    }

    @Override
    public void cancel() {
        // Don't know what to do without it....
    }

    @Override
    public void dismiss() {
        // Don't know what to do without it....
    }
}