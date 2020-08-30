package com.learning.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogInterface {

    TextView displayTextView;
    TextView operationTextView;
    Button clickedButton;
    InputEvaluator inputEvaluator;
    CalculatorState calculatorState;
    AlertDialog.Builder warningDialogBuilder;
    String stream = "";
    Float operandOne;
    Float operandTwo;
    MathOperator operator;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.main_displayTextView);
        operationTextView = findViewById(R.id.main_operationTextView);
        inputEvaluator = new InputEvaluator();
    }

    public void numberInputGotClicked(View view) {
        clickedButton = (Button) view;
        String inputNumber = clickedButton.getText().toString();
        stream += inputNumber;
        String tempString;

        if(!calculatorState.getOperatorPresent()) {
            operandOne = Float.parseFloat(stream);
            calculatorState.resetState(true, false, false); // Change this....
        } else {
            operandTwo = Float.parseFloat(stream);
            calculatorState.resetState(true, true, true); // Change this....
        }
    }

    public void operatorsClicked(View view) {
        clickedButton = (Button) view;
        String inputOperator = clickedButton.getText().toString();
        calculatorState = new CalculatorState();

        if (calculatorState.getOperandOnePresent() && !calculatorState.getOperatorPresent()) {

            calculatorState.resetState(true, false, true); // Change this....
        } else
            this.showWarningAlertDialog("Warning!", "Can't perform this operation!");
    }

    private void showWarningAlertDialog(String warningTitle, String warningMessage){
        warningDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        warningDialogBuilder.setTitle(warningTitle)
                .setMessage(warningMessage)
                .setNegativeButton("Cancel", null);

        AlertDialog warningAlertDialog = warningDialogBuilder.create();
        warningAlertDialog.show();
    }

    public void resetButtonGotClicked(View view) {
        displayTextView.setText("0");
        calculatorState.resetState(false, true, false); // Change this....
    }

    public void evaluateButtonGotClicked(View view) {
        clickedButton = (Button) view;

        if(calculatorState.canCalculate()){
            // Evaluate the result, and update the screen....

            calculatorState.resetState(true, false, false); // Change this....
        } else
            this.showWarningAlertDialog("Warning", "Can't evaluate now!");
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