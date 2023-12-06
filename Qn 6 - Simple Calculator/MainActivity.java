package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplecalc.R;

public class MainActivity extends AppCompatActivity {
    private EditText selectedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.addn);
        Button subButton = findViewById(R.id.sub);
        Button mulButton = findViewById(R.id.mul);
        Button divButton = findViewById(R.id.div);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add(view);
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub(view);
            }
        });
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mul(view);
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                div(view);
            }
        });

        // Make sure that these buttons and EditTexts are present in your layout
        for (int i = 0; i <= 9; i++) {
            int buttonId = getResources().getIdentifier("b" + i, "id", getPackageName());
            Button button = findViewById(buttonId);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        appendToSelectedEditText(((Button) view).getText().toString());
                    }
                });
            }
        }

        EditText editText1 = findViewById(R.id.et1);
        EditText editText2 = findViewById(R.id.et2);
        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedEditText = editText1;
                selectedEditText.requestFocus(); // Set focus programmatically
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedEditText = editText2;
                selectedEditText.requestFocus(); // Set focus programmatically
            }
        });

    }

    void add(View view) {
        performOperation('+');
    }

    void sub(View view) {
        performOperation('-');
    }

    void mul(View view) {
        performOperation('*');
    }

    void div(View view) {
        performOperation('/');
    }

    private void performOperation(char operator) {
        try {
            EditText editText1 = findViewById(R.id.et1);
            EditText editText2 = findViewById(R.id.et2);
            TextView resultTextView = findViewById(R.id.res);

            if (editText1 == null || editText2 == null || resultTextView == null) {
                showToast("UI components not found");
                return;
            }

            String num1 = editText1.getText().toString();
            int n1 = Integer.parseInt(num1);

            String num2 = editText2.getText().toString();
            int n2 = Integer.parseInt(num2);

            int result = 0;

            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    // Check for division by zero
                    if (n2 != 0) {
                        result = n1 / n2;
                    } else {
                        showToast("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            resultTextView.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            showToast("Invalid input. Please enter valid numbers.");
        }
    }

    private void appendToSelectedEditText(String text) {
        if (selectedEditText != null) {
            String currentText = selectedEditText.getText().toString();
            selectedEditText.setText(currentText + text);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
