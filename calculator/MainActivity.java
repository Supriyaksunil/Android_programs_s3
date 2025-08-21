package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonC, buttonDot, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEql;
    EditText result;

    float mValueOne, mValueTwo;
    boolean addition, subtract, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.edt1);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.button10);
        buttonC = findViewById(R.id.buttonC);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEql = findViewById(R.id.buttonEql);

        View.OnClickListener numberClickListener = v -> {
            Button b = (Button) v;
            result.append(b.getText());
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        buttonDot.setOnClickListener(v -> result.append("."));

        buttonC.setOnClickListener(v -> result.setText(""));

        buttonAdd.setOnClickListener(v -> handleOperator("+"));
        buttonSub.setOnClickListener(v -> handleOperator("-"));
        buttonMul.setOnClickListener(v -> handleOperator("*"));
        buttonDiv.setOnClickListener(v -> handleOperator("/"));

        buttonEql.setOnClickListener(v -> calculateResult());
    }

    private void handleOperator(String operator) {
        String input = result.getText().toString();
        if (input.isEmpty()) {
            result.setText("");
            return;
        }

        try {
            mValueOne = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            result.setText("Error");
            return;
        }

        addition = subtract = multiplication = division = false;

        switch (operator) {
            case "+":
                addition = true;
                break;
            case "-":
                subtract = true;
                break;
            case "*":
                multiplication = true;
                break;
            case "/":
                division = true;
                break;
        }

        result.setText("");
    }

    private void calculateResult() {
        String input = result.getText().toString();
        if (input.isEmpty()) {
            result.setText("");
            return;
        }

        try {
            mValueTwo = Float.parseFloat(input);

            float finalResult = 0;

            if (addition) {
                finalResult = mValueOne + mValueTwo;
                addition = false;
            } else if (subtract) {
                finalResult = mValueOne - mValueTwo;
                subtract = false;
            } else if (multiplication) {
                finalResult = mValueOne * mValueTwo;
                multiplication = false;
            } else if (division) {
                if (mValueTwo == 0) {
                    result.setText("Cannot divide by 0");
                    return;
                }
                finalResult = mValueOne / mValueTwo;
                division = false;
            }

            result.setText(String.valueOf(finalResult));
        } catch (NumberFormatException e) {
            result.setText("Error");
        }
    }
}
