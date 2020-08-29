package com.learning.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayTextView;
    TextView operationTextView;
    Button clickedButton;
    InputEvaluator inputEvaluator;
    CalculatorState calculatorState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.main_displayTextView);
        operationTextView = findViewById(R.id.main_operationTextView);
        inputEvaluator = new InputEvaluator();

    }

    public void numberInputGotClicked(View view) {
        clickedButton = (Button) view;
        String inputNumber = clickedButton.getText().toString();

        if(!calculatorState.getOperandOnePresent()) {
            // Assign the OperandOne....
            // Reset the State....
            calculatorState.resetState(true, false, false); // Change this....
        } else if ( calculatorState.getOperatorPresent() && !calculatorState.getOperandTwoPresent()) {
            // Assign the OperandTwo....
            // Reset the state....
            calculatorState.resetState(true, true, true); // Change this....
        } else {
            // Use input stream somehow to extract the float number
        }
    }

    public void operatorsClicked(View view) {
        clickedButton = (Button) view;
        String inputOperator = clickedButton.getText().toString();

        if (calculatorState.getOperandOnePresent() && !calculatorState.getOperatorPresent()) {
            // Assign the operator....

            // Reset the state....
            calculatorState.resetState(true, false, true); // Change this....
        } else {

        }
    }

    public void resetButtonGotClicked(View view) {
        // Just simple update the screen....
        displayTextView.setText("0");
        // Reset the state....
        calculatorState.resetState(false, true, false); // Change this....
    }

    public void evaluateButtonGotClicked(View view) {
        clickedButton = (Button) view;

        if(calculatorState.canCalculate()){
            // Evaluate the result, and update the screen....

            // Reset the state....
            calculatorState.resetState(true, false, false); // Change this....
        } else {
            // Show warning....
        }
    }
}